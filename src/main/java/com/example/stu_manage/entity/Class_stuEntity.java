package com.example.stu_manage.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName("class_stu")
public class Class_stuEntity {
    private Integer id;
    private Integer class_id;
    private Integer stu_id;
}
