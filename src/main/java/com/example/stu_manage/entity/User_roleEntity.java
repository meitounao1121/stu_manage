package com.example.stu_manage.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/* 用户_角色表*/
@Data
@TableName("user_role")
public class User_roleEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer user_id;
    private Integer role_id;
}
