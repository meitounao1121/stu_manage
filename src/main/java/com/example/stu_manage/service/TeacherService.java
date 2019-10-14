package com.example.stu_manage.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.stu_manage.dto.TeacherDto;
import com.example.stu_manage.entity.CourseTeacherEntity;
import com.example.stu_manage.entity.TeacherEntity;

import java.util.List;

public interface TeacherService extends IService<TeacherEntity> {

    //查询所有老师
    Page<TeacherDto> getAllTeachers(String page, String limit);

    //条件查询一部分教师信息
    List<TeacherDto> getSomeTeachers(String teacherInfo);

    //新增一条老师的信息
   int addOneTeacher(TeacherEntity teacherEntity);

   //查询所有老师名字
    List<TeacherEntity> getTeacherNameAndId();

    //为课程添加任教老师
    int  addCourseTeacher(CourseTeacherEntity courseTeacherEntity);

    //查询未当班主任的老师姓名和id
    List<TeacherEntity> getTeacherNameId();

    /* 更新一个老师的信息 l*/
    void update(TeacherEntity teacherEntity,Integer id);

    /* 查询学生的信息 */
    TeacherEntity queryMesById(Integer id);
}
