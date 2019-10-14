package com.example.stu_manage.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/* 班级信息表*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("class_info")
public class ClassEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String class_name;
}
