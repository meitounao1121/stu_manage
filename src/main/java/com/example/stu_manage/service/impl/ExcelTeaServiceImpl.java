package com.example.stu_manage.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.stu_manage.dao.ExcelTeaDao;
import com.example.stu_manage.entity.*;
import com.example.stu_manage.service.ExcelTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelTeaServiceImpl extends ServiceImpl<ExcelTeaDao, TeacherEntity> implements ExcelTeaService {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private User_TeacherServiceImpl user_teacherServiceImpl;
    @Autowired
    private User_roleServiceImpl user_roleServiceImpl;

    @Override
    public void doinsert(List<TeacherEntity> list_teainfo) {
        //添加老师表
        this.insertBatch(list_teainfo);
        //添加user表
        List<UserEntity> list_user = new ArrayList<>();
        for (int i = 0; i < list_teainfo.size(); i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUser_name(list_teainfo.get(i).getTea_name());
            userEntity.setPassword("111111");
            list_user.add(i,userEntity);
        }
        userServiceImpl.insertBatch(list_user);
        //添加user_tea表
        List<User_TeacherEntity> list_ut = new ArrayList<>();
        for (int i = 0; i < list_teainfo.size(); i++) {
            User_TeacherEntity user_teacherEntity = new User_TeacherEntity();
            user_teacherEntity.setTid(list_teainfo.get(i).getId());
            user_teacherEntity.setUid(list_user.get(i).getId());
            list_ut.add(i,user_teacherEntity);
        }
        user_teacherServiceImpl.insertBatch(list_ut);
        //添加user_role表
        List<User_roleEntity> list_ur = new ArrayList<>();
        for (int i = 0; i < list_user.size(); i++) {
            User_roleEntity user_roleEntity = new User_roleEntity();
            user_roleEntity.setRole_id(3);
            user_roleEntity.setUser_id(list_user.get(i).getId());
            list_ur.add(i,user_roleEntity);
        }
        user_roleServiceImpl.insertBatch(list_ur);
    }
}
