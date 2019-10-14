package com.example.stu_manage.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.stu_manage.entity.TeacherEntity;

import java.util.List;

public interface ExcelTeaService extends IService<TeacherEntity> {
    void doinsert(List<TeacherEntity> list_teainfo);
}
