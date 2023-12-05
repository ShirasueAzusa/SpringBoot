package com.ktjiaoyu.crm.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.query.MPJQueryWrapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.ktjiaoyu.crm.entity.Role;
import com.ktjiaoyu.crm.entity.User;
import com.ktjiaoyu.crm.service.RoleService;
import com.ktjiaoyu.crm.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public record UserController(UserService userService,
                             RoleService roleService) {
    @RequestMapping("/dologin")
    public String login(String usrName, String usrPassword, Model model, HttpSession session) {
        MPJQueryWrapper<User> wrapper = new MPJQueryWrapper<>();
        wrapper.selectAll(User.class);
        wrapper.eq("usr_name", usrName);
        wrapper.eq("usr_password", usrPassword);
        User user = userService.getOne(wrapper);
        if (user != null) {
            session.setAttribute("loginUser", user);
            return "main";
        }
        model.addAttribute("msg", "用户名或密码错误，登录失败！");
        return "forward:/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @RequestMapping("/user/list")
    public String list(Model model, String usrName, Long roleId,
                       @RequestParam(required = false, defaultValue = "1") Long pageIndex) {
        MPJLambdaWrapper<User> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(User.class);
        wrapper.selectAll(Role.class);
        wrapper.innerJoin(Role.class, Role::getRoleId, User::getUsrRoleId);
        wrapper.eq(StringUtils.hasText(usrName), User::getUsrName, usrName);
        wrapper.eq(roleId != null && roleId != 0, Role::getRoleId, roleId);
        Page<User> userPager = userService.pageDeep(new Page<>(pageIndex, 5), wrapper);
        model.addAttribute("userPager", userPager);
        model.addAttribute("usrName", usrName);
        model.addAttribute("roleId", roleId);
        List<Role> roles = roleService.list();
        model.addAttribute("roles", roles);
        return "user/list";
    }

    @RequestMapping("/user/add")
    public String add(Model model) {
        List<Role> roles = roleService.list();
        model.addAttribute("roles", roles);
        return "user/add";
    }

    @RequestMapping("/user/save")
    public String save(User user) {
        userService.save(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/user/edit")
    public String edit(Long usrId, Model model) {
        User user = userService.getByIdDeep(usrId);
        List<Role> roles = roleService.list();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "user/edit";
    }

    @RequestMapping("/user/del")
    @ResponseBody
    public Map<String, String> del(Long usrId) {
        Map<String, String> map = new HashMap<>();
        if (userService.removeById(usrId))
            map.put("delResult", "true");
        else
            map.put("delResult", "false");
        return map;
    }
}
