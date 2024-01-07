package com.taoai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taoai.dto.LoginFormDTO;
import com.taoai.dto.Result;
import com.taoai.entity.User;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author  taoai
 *  
 */
public interface IUserService extends IService<User> {

    /**
     * 发送短信验证码
     * @param phone 手机号
     * @param session session
     * @return 验证码
     */
    Result sendCode(String phone, HttpSession session);

    /**
     * 用户登录
     * @param loginForm 用户登录信息封装对象
     * @param session session
     * @return 登录状态
     */
    Result login(LoginFormDTO loginForm, HttpSession session);

    /**
     * 根据手机号创建新用户
     * @param phone 手机号
     * @return 返回创建信息
     */
    User createUser(String phone);
}
