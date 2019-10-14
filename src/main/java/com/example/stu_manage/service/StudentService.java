package com.example.stu_manage.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.stu_manage.dto.StudentCourseScoreDto;
import com.example.stu_manage.dto.StudentDto;
import com.example.stu_manage.entity.StudentEntity;

import java.util.List;

public interface StudentService extends IService<StudentEntity> {


    /* 查询学生的信息 */
    StudentEntity queryById(Integer id);

    /* 更新一个学生的信息 */
    void update(StudentEntity studentEntity,Integer id);

    /* 新增一条学生的信息 */
    int addOneStudent(StudentEntity studentEntity);

    /* 查询所有学生 */
    Page<StudentDto> getAllStudents(String page, String limit);

    /*条件查询学生 l*/
    Page<StudentDto> getSomeStudents(String studentInfo, String page, String limit);



    //查询某位同学的各科成绩根据学号
    List<StudentCourseScoreDto> getStudentCourseScore(Integer sid);
}
