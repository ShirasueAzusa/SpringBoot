package com.ktjiaoyu.crm.web.controller;

import com.ktjiaoyu.crm.entity.Role;
import com.ktjiaoyu.crm.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public record RoleController(RoleService roleService) {
    @RequestMapping("/role/json")
    @ResponseBody
    public List<Role> findAllRoles() {
        return roleService.list();
    }
}
