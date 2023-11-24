package com.ktjiaoyu.demo.service.impl;

import com.ktjiaoyu.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
record DemoServiceImplTest(@Autowired DemoService demoService) {

    @Test
    void sayHello() {
        log.info(demoService.sayHello());
    }
}