package com.ktjiaoyu.crm.entity;

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
@TableName("sys_right")
public class Right implements Serializable {
    @Serial
    private static final long serialVersionUID = 7334696260073070011L;

    @TableId
    @TableField("right_code")
    private String rightCode;
    @TableField("right_parent_code")
    private String rightParentCode;
    @TableField("right_type")
    private String rightType;
    @TableField("right_text")
    private String rightText;
    @TableField("right_url")
    private String rightUrl;
    @TableField("right_tip")
    private String rightTip;
}

