package com.ktjiaoyu.crm.service;

import com.ktjiaoyu.crm.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
record UserServiceTest(@Autowired UserService userService) {
    @Test
    void testFindPageByMap() {
        int page = 0, size = 2;
        Sort sort = Sort.by(Sort.Direction.DESC, "usrId");
        Pageable pageable = PageRequest.of(page, size, sort);
        Map param = new HashMap<>();
        param.put("roleId", 8L);
        Page<User> userPage = userService.findPageByMap(param, pageable);

        System.out.println("总记录数：" + userPage.getTotalElements());
        System.out.println("总页数：" + userPage.getTotalPages());
        System.out.println("当前页数：" + userPage.getNumber() + 1);
        System.out.println("每页记录数：" + userPage.getSize());
        System.out.println("当前页记录数：" + userPage.getNumberOfElements());

        userPage.getContent().forEach(System.out::println);
    }
}