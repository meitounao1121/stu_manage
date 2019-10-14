package com.example.stu_manage.dto;

import lombok.Data;

@Data
public class StudentCourseScoreDto {
    //学生id
    private Integer sid;

    //学生姓名
    private String stu_name;

    //课程id
    private Integer cid;

    //课程名
    private String course_name;

    //学生得分
    private Integer score;
}
