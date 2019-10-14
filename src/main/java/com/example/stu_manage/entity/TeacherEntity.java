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
@TableName("tea_info")
public class TeacherEntity implements Serializable {
    @TableId(type = IdType.AUTO,value="id")
    @Excel(name = "id", width = 25,orderNum = "0")
    private Integer id;

    @TableField(value="tea_name")
    @Excel(name = "tea_name", width = 25,orderNum = "0")
    private  String tea_name;

    @TableField(value="tea_age")
    @Excel(name = "tea_age", width = 25,orderNum = "0")
    private String tea_age;

    @TableField(value="tea_sex")
    @Excel(name = "tea_sex", width = 25,orderNum = "0")
    private String tea_sex;

    @TableField(value="tea_phone")
    @Excel(name = "tea_phone", width = 25,orderNum = "0")
    private String tea_phone;

    @TableField(value="tea_email")
    @Excel(name = "tea_email", width = 25,orderNum = "0")
    private String tea_email;

    @TableField(value="tea_address")
    @Excel(name = "tea_address", width = 25,orderNum = "0")
    private  String tea_address;

}
