package com.ktjiaoyu.crm.service;

import com.ktjiaoyu.crm.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface UserService {
    Page<User> findPageByMap(Map param, Pageable pageable);
}
