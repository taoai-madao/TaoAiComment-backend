package com.taoai.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.taoai.dto.LoginFormDTO;
import com.taoai.dto.Result;
import com.taoai.entity.User;
import com.taoai.entity.UserInfo;
import com.taoai.mapper.UserInfoMapper;
import com.taoai.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taoai.utils.RegexUtils;
import com.taoai.utils.SystemConstants;
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
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {


}
