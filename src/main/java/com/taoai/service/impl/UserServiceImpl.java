package com.taoai.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taoai.dto.LoginFormDTO;
import com.taoai.dto.Result;
import com.taoai.entity.User;
import com.taoai.mapper.UserMapper;
import com.taoai.service.IUserService;
import com.taoai.utils.RegexUtils;
import com.taoai.utils.SystemConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author  taoai
 *  
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    /**
     * 发送短信验证码（模拟）
     * @param phone 手机号
     * @param session Session
     * @return 验证码
     */

    @Override
    public Result sendCode(String phone, HttpSession session) {
        // 1. 校验手机号
        if (RegexUtils.isPhoneInvalid(phone)){
            // 1.1. 失败返回
            return Result.fail("手机号输入错误");
        }
        // 2. 符合，生成验证码
        String code = RandomUtil.randomNumbers(6);
        // 3. 保存验证码到Session
        session.setAttribute(SystemConstants.CODE, code);
        // 4. 模拟发送验证码
        log.debug("发送短信验证码成功，验证码为：{}", code);
        // 5. 返回结果
        return Result.ok();
    }

    /**
     * 用户登录方法实现
     * @param loginForm 用户登录信息封装对象
     * @param session session
     * @return 用户登录
     */
    @Override
    public Result login(LoginFormDTO loginForm, HttpSession session) {

        // 1. 校验手机号
        String phone = loginForm.getPhone();
        if (RegexUtils.isPhoneInvalid(phone)){
            // 2. 判断手机号是否正确
            return Result.fail("手机号格式错误");
        }
        // 3. 校验验证码是否正确
        Object cacheCode = session.getAttribute(SystemConstants.CODE);
        String code = loginForm.getCode();
        if (code == null || !cacheCode.toString().equals(code)){
            return Result.fail("验证码错误");
        }
        // 4. 判断用户是否存在
        User user = query().eq(SystemConstants.PHONE, phone).one();
        // 5. 不存在则创建新用户
        if (user == null){
            user = createUser(phone);
        }
        // 6. 写入用户信息到Session中
        session.setAttribute(SystemConstants.USER, user);
        return null;
    }

    /**
     * 创建新用户
     * @param phone 手机号
     * @return 用户
     */
    @Override
    public User createUser(String phone) {
        // 创建用户
        User user = new User();
        user.setPhone(phone);
        user.setNickName(SystemConstants.USER_NICK_NAME_PREFIX + RandomUtil.randomNumbers(10));
        return user;
    }
}
