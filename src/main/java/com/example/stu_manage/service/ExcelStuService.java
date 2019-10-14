package com.example.stu_manage.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.stu_manage.entity.StudentEntity;

import java.util.List;


public interface ExcelStuService extends IService<StudentEntity> {
    void doinsert(List<StudentEntity> list_stuinfo,String class_id);
}
