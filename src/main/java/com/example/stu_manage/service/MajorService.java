package com.example.stu_manage.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.stu_manage.dto.CourseTeacherClassDto;
import com.example.stu_manage.entity.MajorEntity;

import java.util.List;

public interface MajorService extends IService<MajorEntity> {
    List<MajorEntity> getMajor();

    //查询所有类别课程是否有老师任课
    Page<CourseTeacherClassDto> getAllCourseTeacherClass(String page, String limit);
}
