package com.example.stu_manage.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/*学生信息表*/
@Data
@TableName("stu_info")

public class StudentEntity {

    @TableId(type = IdType.AUTO,value = "id")
    @Excel(name = "id", width = 25,orderNum = "0")
    private Integer id;

    @Excel(name = "stu_name", width = 25,orderNum = "0")
    private String stu_name;

    @Excel(name = "stu_age", width = 25,orderNum = "0")
    private String stu_age;

    @Excel(name = "stu_sex", width = 25,orderNum = "0")
    private String stu_sex;

    @Excel(name = "stu_phone", width = 25,orderNum = "0")
    private String stu_phone;

    @Excel(name = "stu_mail", width = 25,orderNum = "0")
    private String stu_mail;

    @Excel(name = "stu_address", width = 25,orderNum = "0")
    private String stu_address;
}
