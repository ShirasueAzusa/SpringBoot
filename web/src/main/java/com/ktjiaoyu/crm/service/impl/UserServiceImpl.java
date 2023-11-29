package com.ktjiaoyu.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ktjiaoyu.crm.entity.User;
import com.ktjiaoyu.crm.mapper.UserMapper;
import com.ktjiaoyu.crm.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public record UserServiceImpl(UserMapper userMapper) implements UserService {
    @Override
    public User login(String usrName, String usrPassword) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("usr_name", usrName).eq("usr_password", usrPassword);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteUser(Long usrId) {
        return userMapper.deleteById(usrId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public User getUser(Long usrId) {
        return userMapper.selectById(usrId);
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.selectList(null);
    }
}
