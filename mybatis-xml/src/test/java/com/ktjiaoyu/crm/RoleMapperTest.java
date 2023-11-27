package com.ktjiaoyu.crm;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ktjiaoyu.crm.entity.Role;
import com.ktjiaoyu.crm.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public record RoleMapperTest(@Autowired RoleMapper roleMapper) {

    @Test
    void testInsert() {
        roleMapper.insert(new Role(9L, "副总经理", null, 1));
    }

    @Test
    void testSelectById() {
        Role role = roleMapper.selectById(9L);
        System.out.println(role);
    }

    @Test
    void testSelectList() {
        List<Role> list = roleMapper.selectList(null);
        for (Role role : list) System.out.println(role);
    }

    @Test
    void testUpdate() {
        UpdateWrapper<Role> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("role_id", 9L).set("role_desc", "也不知道干啥的");
        roleMapper.update(updateWrapper);
    }

    @Test
    void testDelete() {
        roleMapper.deleteById(9L);
    }
}
