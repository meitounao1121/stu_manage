package com.example.stu_manage.service;


import com.baomidou.mybatisplus.service.IService;
import com.example.stu_manage.entity.User_roleEntity;

public interface User_roleService extends IService<User_roleEntity> {
    /* 为user添加一个角色*/
    int addOneUser_role(User_roleEntity user_roleEntity);
}
