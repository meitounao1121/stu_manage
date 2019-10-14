package com.example.stu_manage.dto;

import lombok.Data;

@Data
public class Client_UserDto {
    private Integer client_id;

    private String client_name;

    private String client_sex;

    private String client_phone;

    private String client_email;

    private String client_detail;

    private Integer stu_id;

    private String stu_name;

    private String stu_pass;
}
