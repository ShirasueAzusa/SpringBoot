package com.ktjiaoyu.crm.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.query.MPJQueryWrapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.ktjiaoyu.crm.entity.Role;
import com.ktjiaoyu.crm.entity.User;
import com.ktjiaoyu.crm.service.RoleService;
import com.ktjiaoyu.crm.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public record UserController(UserService userService,
                             RoleService roleService) {
    @RequestMapping("/dologin")
    public String login(String usrName, String usrPassword, Model model, HttpSession session) {
        if (StringUtils.hasText(usrName) && StringUtils.hasText(usrPassword)) {
            MPJQueryWrapper<User> wrapper = new MPJQueryWrapper<>();
            wrapper.selectAll(User.class);
            wrapper.eq("usr_name", usrName);
            wrapper.eq("usr_password", usrPassword);
            User user = userService.getOne(wrapper);
            if (user != null) {
                session.setAttribute("loginUser", user);
                return "main";
            }
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
    public String userList(Model model, String usrName, Long roleId,
                           @RequestParam(required = false, defaultValue = "1") Long pageIndex) {
        MPJLambdaWrapper<User> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(User.class);
        wrapper.selectAll(Role.class);
        wrapper.innerJoin(Role.class, Role::getRoleId, User::getUsrRoleId);
        wrapper.like(StringUtils.hasText(usrName), User::getUsrName, usrName);
        wrapper.eq(roleId != null && roleId != 0, Role::getRoleId, roleId);
        IPage<User> userPager = userService.pageDeep(new Page<>(pageIndex, 5), wrapper);
        model.addAttribute("userPager", userPager);
        model.addAttribute("usrName", usrName);
        model.addAttribute("roleId", roleId);
        model.addAttribute("roles", getRoleList());
        return "user/list";
    }

    @RequestMapping("/user/add")
    public String addUser(Model model) {
        model.addAttribute("roles", getRoleList());
        return "user/add";
    }

    @RequestMapping("/user/save")
    public String saveUser(User user) {
        userService.save(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/user/edit")
    public String editUser(Long usrId, Model model) {
        User user = userService.getByIdDeep(usrId);
        model.addAttribute("user", user);
        model.addAttribute("roles", getRoleList());
        return "user/edit";
    }

    @RequestMapping("/user/del")
    @ResponseBody
    public Map<String, Boolean> deleteUser(Long usrId) {
        return Map.of("delResult", userService.removeById(usrId));
    }

    private List<Role> getRoleList() {
        return roleService.list();
    }

}
