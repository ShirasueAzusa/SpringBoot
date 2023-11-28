package com.ktjiaoyu.crm.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ktjiaoyu.crm.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public record RoleMapperTest(@Autowired RoleMapper roleMapper) {
    @Test
    void doTest() {
        testInsert();
        testSelectById();
        testUpdate();
        testSelectList();
        testDelete();
    }

    @Test
    void testInsert() {
        log.trace("==>  ================ INSERT ================");
        roleMapper.insert(new Role(9L, "副总经理", null, 1));
        log.trace("");
    }

    @Test
    void testSelectById() {
        log.trace("==>  ============= SELECT BY ID =============");
        Role role = roleMapper.selectById(9L);
        log.info(" ==>  " + role.toString());
        log.trace("");
    }

    @Test
    void testSelectList() {
        log.trace("==>  ============== SELECT LIST ==============");
        List<Role> list = roleMapper.selectList(null);
        for (Role role : list) log.info(" ==>  " + role.toString());
        log.trace("");
    }

    @Test
    void testUpdate() {
        log.trace("==>  ================ UPDATE ================");
        UpdateWrapper<Role> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("role_id", 9L).set("role_desc", "也不知道干啥的");
        roleMapper.update(updateWrapper);
        log.trace("");
    }

    @Test
    void testDelete() {
        log.trace("==>  ================ DELETE ================");
        roleMapper.deleteById(9L);
        log.trace("");
    }
}
