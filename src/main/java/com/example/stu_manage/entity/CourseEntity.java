package com.example.stu_manage.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@Data
@TableName("course_info")
public class CourseEntity {

    @TableId(type = IdType.AUTO,value = "id")
    private Integer id;

    private String course_name;

}