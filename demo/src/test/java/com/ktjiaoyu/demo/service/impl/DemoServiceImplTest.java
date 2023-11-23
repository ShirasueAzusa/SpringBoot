package com.ktjiaoyu.demo.service.impl;

import com.ktjiaoyu.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
record DemoServiceImplTest(@Autowired DemoService demoService) {
    @Test
    void testSayHello() {
        String msg = demoService.sayHello();
        System.out.println("msg: " + msg);
    }
}