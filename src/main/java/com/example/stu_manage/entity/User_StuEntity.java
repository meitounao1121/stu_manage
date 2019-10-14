package com.example.stu_manage.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user_stu")
public class User_StuEntity implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer uid;
    private Integer sid;
}
