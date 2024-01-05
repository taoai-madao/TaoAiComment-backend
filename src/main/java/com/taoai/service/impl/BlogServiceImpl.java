package com.taoai.service.impl;

import com.taoai.entity.Blog;
import com.taoai.mapper.BlogMapper;
import com.taoai.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author  taoai
 *  
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
