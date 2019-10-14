package com.example.stu_manage.dto;

import lombok.Data;

@Data
public class ClassTeacherDto {
    //班级id
    private Integer cid;

    //班级名称
    private String class_name;

    //教师id
    private Integer tid;

    //教师名字
    private String tea_name;

    //班级人数
    private Integer classQ;

}
