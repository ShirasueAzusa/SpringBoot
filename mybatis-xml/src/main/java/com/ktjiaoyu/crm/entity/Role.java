package com.ktjiaoyu.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@TableName("sys_role")
public class Role implements Serializable {
    @Serial
    private static final long serialVersionUID = -8790216583917853416L;

    @TableId(type = IdType.AUTO)
    @TableField("role_id")
    private Long roleId;
    @TableField("role_name")
    private String roleName;
    @TableField("role_desc")
    private String roleDesc;
    @TableField("role_flag")
    private Integer roleFlag;

    public Role() {
    }

    public Role(Long roleId, String roleName, String roleDesc, Integer roleFlag) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.roleFlag = roleFlag;
    }
}
