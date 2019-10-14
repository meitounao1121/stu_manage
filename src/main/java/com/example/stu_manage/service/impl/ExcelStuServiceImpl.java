package com.example.stu_manage.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.stu_manage.dao.ExcelStuDao;
import com.example.stu_manage.entity.*;
import com.example.stu_manage.service.ExcelStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelStuServiceImpl extends ServiceImpl<ExcelStuDao,StudentEntity> implements ExcelStuService {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private User_StudentServiceImpl user_studentServiceImpl;
    @Autowired
    private User_roleServiceImpl user_roleServiceImpl;
    @Autowired
    private Class_stuServiceImpl class_stuServiceImpl;

    @Override
    public void doinsert(List<StudentEntity> list_stuinfo, String class_id) {
        //添加学生表
        this.insertBatch(list_stuinfo);
        //添加user表
        List<UserEntity> list_user = new ArrayList<>();
        for (int i = 0; i < list_stuinfo.size(); i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setPassword("111111");
            userEntity.setUser_name(list_stuinfo.get(i).getStu_name());
            list_user.add(i,userEntity);
        }
        userServiceImpl.insertBatch(list_user);
        //添加user_stu表
        List<User_StudentEntity> list_us = new ArrayList<>();
        for (int i = 0; i < list_stuinfo.size(); i++) {
            User_StudentEntity user_studentEntity = new User_StudentEntity();
            user_studentEntity.setUid(list_user.get(i).getId());
            user_studentEntity.setSid(list_stuinfo.get(i).getId());
            list_us.add(i,user_studentEntity);
        }
        user_studentServiceImpl.insertBatch(list_us);
        //添加user_role表
        List<User_roleEntity> list_ur = new ArrayList<>();
        for (int i = 0; i < list_user.size(); i++) {
            User_roleEntity user_roleEntity = new User_roleEntity();
            user_roleEntity.setUser_id(list_user.get(i).getId());
            user_roleEntity.setRole_id(2);
            list_ur.add(i,user_roleEntity);
        }
        user_roleServiceImpl.insertBatch(list_ur);
        //添加class_stu表
        List<Class_stuEntity> list_cs = new ArrayList<>();
        for (int i = 0; i < list_stuinfo.size(); i++) {
            Class_stuEntity class_stuEntity = new Class_stuEntity();
            class_stuEntity.setStu_id(list_stuinfo.get(i).getId());
            class_stuEntity.setClass_id(Integer.parseInt(class_id));
            list_cs.add(i,class_stuEntity);
        }
        class_stuServiceImpl.insertBatch(list_cs);
    }
}
