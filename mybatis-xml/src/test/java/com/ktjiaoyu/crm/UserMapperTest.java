package com.ktjiaoyu.crm;

import com.ktjiaoyu.crm.entity.User;
import com.ktjiaoyu.crm.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
record UserMapperTest(@Autowired UserMapper userMapper) {

    @Test
    void testInsert() {
        userMapper.insert(new User("ktjiaoyu", "123456", 8L, 1));
    }

    @Test
    void testSelectById() {
        User user = userMapper.selectById(18L);
        System.out.println("usrName: " + user.getUsrName());
    }

    @Test
    void testFindAll() {
        List<User> list = userMapper.selectList(null);
        for (User user : list) {
            System.out.println("usrName: " + user.getUsrName());
        }
    }

}
