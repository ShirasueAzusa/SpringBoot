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
@TableName("sys_role_right")
public class RoleRight implements Serializable {
    @Serial
    private static final long serialVersionUID = 341157730709120608L;

    @TableId(type = IdType.AUTO)
    @TableField("rf_id")
    private Long rfId;
    @TableField("rf_role_id")
    private Long rfRoleId;
    @TableField("rf_right_code")
    private String rfRightCode;
}

