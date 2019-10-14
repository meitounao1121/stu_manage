package com.example.stu_manage.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO,value = "id")
    @Excel(name = "id", width = 25,orderNum = "0")
    private Integer id;

    @TableField(value = "user_name")
    @Excel(name = "user_name", width = 25,orderNum = "0")
    private String user_name;

    @TableField(value = "password")
    @Excel(name = "password", width = 25,orderNum = "0")
    private String password;

    @TableField(exist = false)
    private String code;
}
