package com.example.stu_manage.dto;

import lombok.Data;

@Data
public class ClassStudentDto {
    //班级id
    private Integer cid;

    //班级名称
    private String class_name;

    //学生id
    private Integer sid;

    //学生姓名
    private String stu_name;
}
