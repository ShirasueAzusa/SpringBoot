package com.ktjiaoyu.demo.web;

import com.ktjiaoyu.demo.comm.KtjiaoyuInfo;
import com.ktjiaoyu.demo.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record HelloController(KtjiaoyuInfo ktjiaoyuInfo,
                              DemoService demoService) {
    @RequestMapping("/hello")
    public String hello() {
        String msg = demoService.sayHello();
        msg += " " + ktjiaoyuInfo.getName() + " " + ktjiaoyuInfo.getEmail();
        return msg;
    }
}
