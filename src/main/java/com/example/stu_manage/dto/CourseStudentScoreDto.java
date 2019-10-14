package com.example.stu_manage.dto;

import lombok.Data;

@Data
public class CourseStudentScoreDto {
    //课程班级id
    private Integer ctid;

    //课程名
    private String course_name;

    //班级名
    private String course_class;

    //学生id
    private Integer sid;

    //学生姓名
    private String stu_name;

    //学生得分
    private Integer score;
}
