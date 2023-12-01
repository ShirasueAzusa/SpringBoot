package com.ktjiaoyu.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -11678175052773187L;

    @TableId(type = IdType.AUTO)
    @TableField("usr_id")
    private Long usrId;
    @TableField("usr_name")
    private String usrName;
    @TableField("usr_password")
    private String usrPassword;
    @TableField("usr_role_id")
    private Long usrRoleId;
    @TableField("usr_flag")
    private Integer usrFlag;
}
