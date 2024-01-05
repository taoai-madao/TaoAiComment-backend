package com.taoai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taoai.entity.User;
import com.taoai.mapper.UserMapper;
import com.taoai.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author  taoai
 *  
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
