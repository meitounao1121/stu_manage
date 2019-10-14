package com.example.stu_manage.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.stu_manage.entity.User_StudentEntity;

public interface User_StudentService extends IService<User_StudentEntity> {
    /* user_stu 关系表的插入 l*/
    int addUserStudent(User_StudentEntity user_studentEntity);
}
