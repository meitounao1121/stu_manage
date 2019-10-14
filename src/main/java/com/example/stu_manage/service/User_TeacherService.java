package com.example.stu_manage.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.stu_manage.entity.UserEntity;
import com.example.stu_manage.entity.User_TeacherEntity;

public interface User_TeacherService extends IService<User_TeacherEntity> {

    int addUserTeacher(User_TeacherEntity user_teacherEntity);
}
