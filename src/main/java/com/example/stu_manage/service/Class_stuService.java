package com.example.stu_manage.service;

import com.example.stu_manage.dto.ClassStudentDto;
import com.example.stu_manage.entity.Class_stuEntity;

import java.util.List;

public interface Class_stuService {
    //
    int addOneClass_stu(Class_stuEntity class_stuEntity);

    //查询班级对应的所有学生
    List<ClassStudentDto> getClassStudent(Integer cid);
}
