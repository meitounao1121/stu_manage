package com.example.stu_manage.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Major_CourseDto {
    private Integer id;
    private String major_name;
    private String course_name;
    private String tea_name;
    private String course_class;
    private String remain;
    private LocalDateTime deadline;
    private String course_time;
    private String course_place;
}
