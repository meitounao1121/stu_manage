package com.example.stu_manage.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_tea")
public class User_TeacherEntity implements Serializable {

    @TableId(type = IdType.AUTO,value = "id")
    private Integer id;
    private  Integer uid;
    private  Integer tid;
}
