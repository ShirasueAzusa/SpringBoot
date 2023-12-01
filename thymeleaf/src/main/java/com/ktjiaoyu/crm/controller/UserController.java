package com.ktjiaoyu.crm.controller;

import com.ktjiaoyu.crm.entity.User;
import com.ktjiaoyu.crm.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public record UserController(UserService userService) {
    @RequestMapping("/dologin")
    public String dologin(String usrName, String usrPassword, HttpServletRequest request) {
        User user = userService.login(usrName, usrPassword);
        if (user != null) {
            request.getSession().setAttribute("loginUser", user);
            return "main";
        }
        request.setAttribute("message", "登录失败，用户名或密码错误！");
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return "login";
    }

    @GetMapping("/user/list")
    public String findUsers(String usrName, Long roleId, Model model) {
        List<User> list = userService.findAllUsers();
        model.addAttribute("users", list);
        return "/user/list";
    }
}
