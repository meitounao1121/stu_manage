package com.example.stu_manage.dto;

import lombok.Data;

@Data
public class PermissionDto {
    Integer id;
    Integer pid;
    String permission_name;
    String permission_url;
}
