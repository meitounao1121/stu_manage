package com.example.stu_manage.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("ct_s")
public class Course_Teacher_StuEntity implements Serializable {
    @TableId("type = IdType.AUTO")
    private int id;
    private int ct_id;
    private int stu_id;
}
