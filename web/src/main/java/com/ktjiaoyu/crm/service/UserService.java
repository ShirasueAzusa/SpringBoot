package com.ktjiaoyu.crm.service;

import com.ktjiaoyu.crm.entity.User;

import java.util.List;

public interface UserService {
    User login(String usrName, String usrPassword);

    int addUser(User user);

    int deleteUser(Long usrId);

    int updateUser(User user);

    User getUser(Long usrId);

    List<User> findAllUsers();
}
