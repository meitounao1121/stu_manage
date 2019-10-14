package com.example.stu_manage.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@Data
@TableName("score")

public class ScoreEntity {
    @TableId(type = IdType.AUTO,value = "id")
    private Integer id;
    private Integer course_tea_id;
    private Integer stu_id;
    private Integer score;

    @TableField(exist = false)
    private String course_name;
    @TableField(exist = false)
    private String stu_name;
    @TableField(exist = false)
    private String course_class;
}
