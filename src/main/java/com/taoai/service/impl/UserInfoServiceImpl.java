package com.taoai.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.taoai.dto.Result;
import com.taoai.entity.UserInfo;
import com.taoai.mapper.UserInfoMapper;
import com.taoai.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taoai.utils.RegexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author  taoai
 * @since 2021-12-24
 */
@Slf4j
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

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
        session.setAttribute("code", code);
        // 4. 模拟发送验证码
        log.debug("发送短信验证码成功，验证码为：{}", code);
        // 5. 返回结果
        return Result.ok();
    }
}
