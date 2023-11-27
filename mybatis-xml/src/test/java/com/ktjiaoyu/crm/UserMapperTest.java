package com.ktjiaoyu.crm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktjiaoyu.crm.entity.User;
import com.ktjiaoyu.crm.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
record UserMapperTest(@Autowired UserMapper userMapper) {

    @Test
    void testInsert() {
        userMapper.insert(new User("ktjiaoyu", "123456", 8L, 1));
    }

    @Test
    void testSelectById() {
        User user = userMapper.selectById(18L);
        System.out.println(user);
    }

    @Test
    void testSelectList() {
        List<User> list = userMapper.selectList(null);
        for (User user : list) System.out.println(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUsrId(17L);
        user.setUsrName("包庇");
        userMapper.updateById(user);
    }

    @Test
    void testDelete() {
        userMapper.deleteById(18L);
    }

    @Test
    public void testPagination() {
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
        for (User user : userPager.getRecords()) {
            System.out.println(user);
        }
    }

}
