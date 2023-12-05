package com.ktjiaoyu.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktjiaoyu.crm.entity.Role;
import com.ktjiaoyu.crm.mapper.RoleMapper;
import com.ktjiaoyu.crm.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
