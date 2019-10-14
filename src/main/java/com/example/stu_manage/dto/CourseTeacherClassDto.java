package com.example.stu_manage.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class CourseTeacherClassDto {
    //课程教师关系表id
    private Integer ct_id;
    //课程类别id
    private Integer mi_id;
    //课程类别名字
    private String major_name;
    //课程id
    private Integer cid;
    //课程名字
    private String course_name;
    //教师id
    private  Integer tid;
    //教师名字
    private String tea_name;
    //课程班级名字
    private String course_class;
    //课程截至选课时间
    private LocalDateTime deadline;
    //课程上课时间
    private String course_time;
    //课程上课地点
    private String course_place;
}
