package com.ktjiaoyu.crm.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktjiaoyu.crm.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
record UserMapperTest(@Autowired UserMapper userMapper) {
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
        userMapper.insert(new User(18L, "ktjiaoyu", "123456", 8L, 1));
        log.trace("");
    }

    @Test
    void testSelectById() {
        log.trace("==>  ============= SELECT BY ID =============");
        User user = userMapper.selectById(18L);
        log.info(" ==>  " + user.toString());
        log.trace("");
    }

    @Test
    void testSelectList() {
        log.trace("==>  ============== SELECT LIST ==============");
        List<User> list = userMapper.selectList(null);
        for (User user : list) log.info(" ==>  " + user.toString());
        log.trace("");
    }

    @Test
    public void testUpdate() {
        log.trace("==>  ================ UPDATE ================");
        User user = new User();
        user.setUsrId(17L);
        user.setUsrName("包庇");
        userMapper.updateById(user);
        log.trace("");
    }

    @Test
    void testDelete() {
        log.trace("==>  ================ DELETE ================");
        userMapper.deleteById(18L);
        log.trace("");
    }

    @Test
    public void testPagination() {
        log.trace("==>  ============== SELECT PAGE ==============");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("usr_role_id", 2L);//查询条件：角色Id为2
        //分页对象：查询获得User对象，查看第1页的数据，每页显示2条记录
        Page<User> page = new Page<>(1, 2);
        IPage<User> userPager = userMapper.selectPage(page, wrapper);
        System.out.println("总记录数 ---------> " + userPager.getTotal());
        System.out.println("总页数 -----------> " + userPager.getPages());
        System.out.println("当前页数 ---------> " + userPager.getCurrent());
        System.out.println("每页记录数 -------> " + userPager.getSize());
        System.out.println("当前记录 ---------> ");
        for (User user : userPager.getRecords()) log.info(" ==>  " + user.toString());
        log.trace("");
    }
}
