package com.ktjiaoyu.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@TableName("sys_user")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 6347894998393263221L;

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

    public User() {
    }

    public User(String usrName, String usrPassword, Long usrRoleId, Integer usrFlag) {
        this.usrName = usrName;
        this.usrPassword = usrPassword;
        this.usrRoleId = usrRoleId;
        this.usrFlag = usrFlag;
    }
}
