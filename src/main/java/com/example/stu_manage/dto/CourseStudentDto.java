package com.example.stu_manage.dto;

import lombok.Data;

@Data
public class CourseStudentDto {
    //course_tea表的id
    private Integer ctid;

    //课程类别名
    private String major_name;

    //课程名
    private String course_name;

    //课程对应的班级名
    private String course_class;

    //班级人数
    private Integer Q;

}
