package com.ktjiaoyu.crm.web.controller;

import com.ktjiaoyu.crm.entity.User;
import com.ktjiaoyu.crm.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Controller
public record ExampleController(UserService userService) {
    @GetMapping("/hello/{id}")
    public String getUser(@PathVariable("id") Long usrId, Model model) {
        User user = userService.getUser(usrId);
        model.addAttribute("user", user);
        return "demo/hello";
    }

    @GetMapping("/inline")
    public String inline(Model model) {
        model.addAttribute("userName", "ktjiaoyu");
        return "demo/inline";
    }

    @GetMapping("/string")
    public String getString(Model model, HttpServletRequest request) {
        model.addAttribute("userName", "ktjiaoyu");
        request.setAttribute("test", "request");
        request.getSession().setAttribute("test", "session");
        model.addAttribute("date", new Date());
        return "demo/string";
    }

    @GetMapping("/if")
    public String ifunless(Model model) {
        model.addAttribute("flag", "yes");
        return "demo/if";
    }

    @GetMapping("/list")
    public String getUserList(Model model) {
        List<User> list = userService.findAllUsers();
        model.addAttribute("users", list);
        return "demo/list";
    }
}
