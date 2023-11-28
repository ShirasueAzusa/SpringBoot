package com.ktjiaoyu.crm.mapper;

import com.ktjiaoyu.crm.entity.RoleRight;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
record RoleRightMapperTest(@Autowired RoleRightMapper roleRightMapper) {
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
        roleRightMapper.insert(new RoleRight(134L, 1L, "L01"));
        log.trace("");
    }

    @Test
    void testSelectById() {
        log.trace("==>  ============= SELECT BY ID =============");
        RoleRight roleRight = roleRightMapper.selectById(134L);
        log.info(" ==>  " + roleRight.toString());
        log.trace("");
    }

    @Test
    void testSelectList() {
        log.trace("==>  ============== SELECT LIST ==============");
        List<RoleRight> list = roleRightMapper.selectList(null);
        for (RoleRight roleRight : list) log.info(" ==>  " + roleRight.toString());
        log.trace("");
    }

    @Test
    public void testUpdate() {
        log.trace("==>  ================ UPDATE ================");
        RoleRight roleRight = new RoleRight();
        roleRight.setRfId(134L);
        roleRight.setRfRightCode("L0101");
        roleRightMapper.updateById(roleRight);
        log.trace("");
    }

    @Test
    public void testDelete() {
        log.trace("==>  ================ DELETE ================");
        roleRightMapper.deleteById(134L);
        log.trace("");
    }
}