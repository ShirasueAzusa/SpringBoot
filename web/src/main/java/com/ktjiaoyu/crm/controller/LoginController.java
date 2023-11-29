package com.ktjiaoyu.crm.controller;

import com.ktjiaoyu.crm.entity.User;
import com.ktjiaoyu.crm.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public record LoginController(UserService userService) {
    @RequestMapping("/login")
    public String login(String usrName, String usrPassword, Model model, HttpSession session) {
        User user = userService.login(usrName, usrPassword);
        if (user != null) {
            session.setAttribute("loginUser", user);
            return "main";
        }
        model.addAttribute("msg", "用户名或密码错误，登录失败！");
        return "forward:/login.jsp";
    }

    @RequestMapping("/main")
    public String filterTest() {
        return "main";
    }
}
