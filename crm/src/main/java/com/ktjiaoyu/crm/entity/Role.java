package com.ktjiaoyu.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.yulichang.annotation.EntityMapping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@TableName("sys_role")
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    @Serial
    private static final long serialVersionUID = -6991622016678952063L;

    /*设置Id自增长*/
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;
    @TableField("role_name")
    private String roleName;
    @TableField("role_desc")
    private String roleDesc;
    @TableField("role_flag")
    private Integer roleFlag;
    @TableField(exist = false)
    @EntityMapping(thisField = Fields.roleId, joinField = User.Fields.usrRoleId)
    private List<User> users;
}
