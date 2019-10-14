package com.example.stu_manage.dto;

import lombok.Data;

/* 学生信息，和密码, 班级 */
@Data
public class StudentDto {
    private Integer id;
    private String stu_name;
    private String stu_age;
    private String stu_sex;
    private String stu_phone;
    private String stu_mail;
    private String stu_address;
    private String class_name;
    private String password;
    private String class_id;

}
