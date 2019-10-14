package com.example.stu_manage.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@Data
@TableName("class_tea")
public class ClassTeacherEntity {
    @TableId(type = IdType.AUTO,value = "id")
    private Integer id;
    private Integer class_id;
    private Integer tea_id;
}
