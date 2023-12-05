package com.ktjiaoyu.crm.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.ktjiaoyu.crm.entity.Right;
import com.ktjiaoyu.crm.entity.Role;
import com.ktjiaoyu.crm.entity.RoleRight;
import com.ktjiaoyu.crm.service.RightService;
import com.ktjiaoyu.crm.service.RoleRightService;
import com.ktjiaoyu.crm.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public record RoleController(RoleService roleService,
                             RightService rightService,
                             RoleRightService roleRightService) {
    @RequestMapping("/role/list")
    public String list(Model model,
                       @RequestParam(required = false, defaultValue = "1") Long pageIndex,
                       @RequestParam(required = false) String roleName) {
        MPJLambdaWrapper<Role> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(Role.class);
        wrapper.like(StringUtils.hasText(roleName), Role::getRoleName, roleName);
        IPage<Role> rolePage = roleService.pageDeep(new Page<>(pageIndex, 5), wrapper);
        model.addAttribute("rolePage", rolePage);
        model.addAttribute("roleName", roleName);
        return "role/list";
    }

    @GetMapping("/role/json")
    @ResponseBody
    public List<Role> findAllRoles() {
        return roleService.list();
    }

    @GetMapping("/role/add")
    public String add(Model model) {
        List<Right> rights = rightService.list();
        model.addAttribute("rights", rights);
        return "role/add";
    }

    @PostMapping("/role/save")
    public String save(@ModelAttribute Role role, @RequestParam List<String> rightCodes) {
        roleService.save(role);
        long rfId = role.getRoleId();
        List<RoleRight> roleRightList = getRoleRigthList(rfId, rightCodes);
        roleRightService.saveBatch(roleRightList);
        return "redirect:/role/list";
    }
    
    @RequestMapping("/role/del")
    @ResponseBody
    public Map<String, Boolean> del(Long roleId) {
        QueryWrapper<RoleRight> wrapper = new QueryWrapper<>();
        wrapper.eq("rf_role_id", roleId);
        roleRightService.remove(wrapper);
        Map<String, Boolean> resultMap = new HashMap<>();
        resultMap.put("delResult", roleService.removeById(roleId));
        return resultMap;
    }


    @GetMapping("/role/edit")
    public String edit(Long roleId, Model model) {
        Role role = roleService.getById(roleId);
        List<Right> rights = rightService.list();

        List<Right> checkRight = new ArrayList<>();

        for (Right right : rights) {
            if (hasRight(roleId, right.getRightCode())) {
                checkRight.add(right);
            }
        }

        model.addAttribute("roleRights", checkRight);
        model.addAttribute("role", role);
        model.addAttribute("rights", rights);

        return "role/edit";
    }

    private boolean hasRight(Long roleId, String rightCode) {
        QueryWrapper<RoleRight> wrapper = new QueryWrapper<>();
        wrapper.eq("rf_role_id", roleId);
        wrapper.eq("rf_right_code", rightCode);
        return roleRightService.count(wrapper) > 0;
    }

    @PostMapping("/role/edit")
    public String edit(Role role, @RequestParam List<String> rightCodes) {
        roleService.updateById(role);
        long rfId = role.getRoleId();
        List<RoleRight> roleRightList = getRoleRigthList(rfId, rightCodes);
        QueryWrapper<RoleRight> wrapper = new QueryWrapper<>();
        wrapper.eq("rf_role_id", rfId);
        roleRightService.remove(wrapper);
        roleRightService.saveBatch(roleRightList);
        return "redirect:/role/list";
    }

    private List<RoleRight> getRoleRigthList(long rfId, List<String> rightCodes) {
        return rightCodes.stream().map(rightCode -> {
            RoleRight right = new RoleRight();
            right.setRfRoleId(rfId);
            right.setRfRightCode(rightCode);
            return right;
        }).toList();
    }

}
