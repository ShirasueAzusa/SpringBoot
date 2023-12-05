package com.ktjiaoyu.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktjiaoyu.crm.entity.User;
import com.ktjiaoyu.crm.mapper.UserMapper;
import com.ktjiaoyu.crm.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
