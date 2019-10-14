package com.example.stu_manage.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.stu_manage.dto.CourseStudentDto;
import com.example.stu_manage.dto.CourseStudentScoreDto;
import com.example.stu_manage.dto.Major_CourseDto;
import com.example.stu_manage.entity.CourseEntity;
import com.example.stu_manage.entity.MajorEntity;
import util.R;

import java.util.List;

public interface CourseService extends IService<CourseEntity> {


    Page<Major_CourseDto> getCourseByMajor(String page,String limit,String params);

    R skill(int parseInt, int parseInt1, String course_class);

    //根据major_id 查询对应的所有课程
    List<CourseEntity> getCourseByMajorId(int major_id);

    R test();

    Page<Major_CourseDto> gethooseCourse(String page, String limit, String params);

    //查询任课老师所教课程的班级名称 学生人数
    List<CourseStudentDto> getCourseStudent(Integer uid);

    //查询某个课程班级 所有学生的分数
    List<CourseStudentScoreDto> getCourseStudentScore(Integer ctid);
}
