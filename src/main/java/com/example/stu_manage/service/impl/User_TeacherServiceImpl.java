package com.example.stu_manage.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.stu_manage.dao.UserDao;
import com.example.stu_manage.dao.User_TeacherDao;
import com.example.stu_manage.entity.UserEntity;
import com.example.stu_manage.entity.User_TeacherEntity;
import com.example.stu_manage.service.UserService;
import com.example.stu_manage.service.User_TeacherService;
import org.springframework.stereotype.Service;

@Service
public class User_TeacherServiceImpl extends ServiceImpl<User_TeacherDao, User_TeacherEntity> implements User_TeacherService {

    //user_tea 关系表的插入
    @Override
    public int addUserTeacher(User_TeacherEntity user_teacherEntity) {
        this.baseMapper.insert(user_teacherEntity);
        return user_teacherEntity.getId();
    }
}
