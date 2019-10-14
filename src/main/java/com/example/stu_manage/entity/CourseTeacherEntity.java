package com.example.stu_manage.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

@Data
@TableName("course_tea")
public class CourseTeacherEntity {
    @TableId(type= IdType.AUTO,value="id")
    private Integer id;
    private Integer course_id;
    private Integer tea_id;
    private String course_class;
    private Date deadline;
    private String course_time;
    private String course_place;
    @TableField(exist = false)
    private String maxCount;
}
