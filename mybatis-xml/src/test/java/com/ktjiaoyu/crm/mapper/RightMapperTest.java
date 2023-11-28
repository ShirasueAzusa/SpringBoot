package com.ktjiaoyu.crm.mapper;

import com.ktjiaoyu.crm.entity.Right;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
record RightMapperTest(@Autowired RightMapper rightMapper) {
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
        rightMapper.insert(new Right("L060201", "L0602", "Url", "角色添加", "/role/add", null));
        log.trace("");
    }

    @Test
    void testSelectById() {
        log.trace("==>  ============= SELECT BY ID =============");
        Right right = rightMapper.selectById("L060201");
        log.info(" ==>  " + right.toString());
        log.trace("");
    }

    @Test
    void testSelectList() {
        log.trace("==>  ============== SELECT LIST ==============");
        List<Right> list = rightMapper.selectList(null);
        for (Right right : list) log.info(" ==>  " + right.toString());
        log.trace("");
    }

    @Test
    void testUpdate() {
        log.trace("==>  ================ UPDATE ================");
        Right right = new Right();
        right.setRightCode("L060201");
        right.setRightTip("角色添加");
        rightMapper.updateById(right);
        log.trace("");
    }

    @Test
    void testDelete() {
        log.trace("==>  ================ DELETE ================");
        rightMapper.deleteById("L060201");
        log.trace("");
    }
}
