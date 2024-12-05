package com.fms.fmsback.service.impl;

import com.fms.fmsback.entity.User;
import com.fms.fmsback.mapper.UserMapper;
import com.fms.fmsback.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * User Account and Details Service Implementation Class
 * @author Sn0w_15
 * @since 2024-12-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
