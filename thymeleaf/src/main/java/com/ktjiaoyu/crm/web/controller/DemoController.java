package com.ktjiaoyu.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/index")
    public String index() {
        return "demo/index";
    }

    @GetMapping("/fragment")
    public String layout() {
        return "demo/fragment";
    }

    @GetMapping("/test")
    public String test() {
        return "demo/test";
    }
}
