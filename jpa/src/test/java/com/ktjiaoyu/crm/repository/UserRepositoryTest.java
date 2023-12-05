package com.ktjiaoyu.crm.repository;

import com.ktjiaoyu.crm.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootTest
record UserRepositoryTest(@Autowired UserRepository userRepository) {
    @Test
    void testInsert() {
        User user = new User("JPA", "123456", 8L, 1);
        userRepository.save(user);
    }

    @Test
    void testGet() {
        Optional<User> users = userRepository.findById(19L);
        User user = null;
        if (users.isPresent()) user = users.get();
        System.out.println(user);
    }

    @Test
    void testFindByUsrNameLike() {
        List<User> list = userRepository.findByUsrNameLike("%J%");
        if (list != null) list.forEach(System.out::println);
    }

    @Test
    void testFindPageByUsrRoleId() {
        int page = 0, size = 2;
        Sort sort = Sort.by(Sort.Direction.DESC, "usrId");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<User> userPage = userRepository.findPageByUsrRoleId(8L, pageable);

        System.out.println("总记录数：" + userPage.getTotalElements());
        System.out.println("总页数：" + userPage.getTotalPages());
        System.out.println("当前页数：" + userPage.getNumber() + 1);
        System.out.println("每页记录数：" + userPage.getSize());
        System.out.println("当前页记录数：" + userPage.getNumberOfElements());

        userPage.getContent().forEach(System.out::println);
    }
}