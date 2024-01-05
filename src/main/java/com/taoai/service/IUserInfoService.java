package com.taoai.service;

import com.taoai.dto.Result;
import com.taoai.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author  taoai
 * @since 2021-12-24
 */
public interface IUserInfoService extends IService<UserInfo> {

    /**
     * 发送短信验证码
     * @param phone 手机号
     * @param session session
     * @return 验证码
     */
    Result sendCode(String phone, HttpSession session);
}
