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

@Data
@TableName("sys_user")
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 37808849617026314L;

    @TableId(value = "usr_id", type = IdType.AUTO)
    private Long usrId;
    @TableField("usr_name")
    private String usrName;
    @TableField("usr_password")
    private String usrPassword;
    @TableField("usr_role_id")
    private Long usrRoleId;
    @TableField("usr_flag")
    private Integer usrFlag;
    @TableField(exist = false)
    @EntityMapping(thisField = Fields.usrRoleId, joinField = Role.Fields.roleId)
    private Role role;
}
