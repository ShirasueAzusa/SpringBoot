package com.ktjiaoyu.crm.service;

import com.ktjiaoyu.crm.entity.User;

import java.util.List;

public interface UserService {
    User login(String usrName, String usrPassword);

    User addUser(User user);

    void deleteUser(Long usrId);

    User updateUser(User user);

    User getUser(Long usrId);

    List<User> findAllUsers();
}
