package com.example.stu_manage.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.stu_manage.dto.ClassTeacherDto;
import com.example.stu_manage.entity.ClassEntity;
import com.example.stu_manage.entity.ClassTeacherEntity;
import com.example.stu_manage.entity.UserEntity;

import java.util.List;

public interface ClassService extends IService<ClassEntity> {

    List<ClassEntity> getAllClass();

    //查询所有班级对应的班主任
    Page<ClassTeacherDto> getClassTeacher(String page , String limit);

    //查询没有班主任的班级
    List<ClassEntity> getClassWithNoTeacher();

    //为某一个班级添加班主任
    int addClassTeacher(ClassTeacherEntity classTeacherEntity);

    //查看班主任所管理的班级 班级名称编号以及人数
   Page<ClassTeacherDto> getTeacherClass(String page,String limit,Integer id);
}
