package com.example.stu_manage.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@Data
@TableName("major_info")
public class MajorEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String major_name;
}