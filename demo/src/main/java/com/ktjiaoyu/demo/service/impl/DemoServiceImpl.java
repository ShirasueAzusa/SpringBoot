package com.ktjiaoyu.demo.service.impl;

import com.ktjiaoyu.demo.service.DemoService;
import org.springframework.stereotype.Service;

@Service("demoService")
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello() {
        return "hello world";
    }
}
