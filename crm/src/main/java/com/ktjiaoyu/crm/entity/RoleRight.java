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
@TableName("sys_role_right")
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
public class RoleRight implements Serializable {
    @Serial
    private static final long serialVersionUID = -4674208190142122050L;

    @TableId(value = "rf_id", type = IdType.AUTO)
    private Long rfId;
    @TableField("rf_role_id")
    private Long rfRoleId;
    @TableField("rf_right_code")
    private String rfRightCode;
    @EntityMapping(thisField = Fields.rfRightCode, joinField = Right.Fields.rightCode)
    private Right right;
}
