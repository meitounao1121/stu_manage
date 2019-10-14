package com.example.stu_manage.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("client")
public class ClientEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer client_id;

    private String client_name;

    private String client_sex;

    private String client_phone;

    private String client_email;

    private String client_detail;

}
