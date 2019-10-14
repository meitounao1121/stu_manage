package com.example.stu_manage.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.stu_manage.dto.CourseTeacherClassDto;
import com.example.stu_manage.entity.MajorEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MajorDao extends BaseMapper<MajorEntity> {

    @Select("SELECT ct.id AS ct_id," +
            "mi.id AS mi_id," +
            "mi.major_name," +
            "ci.id AS cid," +
            "course_name," +
            "ti.id AS tid," +
            "ti.tea_name,ct.course_class," +
            "deadline,course_time,"+
            "course_place "+
            "FROM major_info mi " +
            "LEFT JOIN major_course mc ON mi.id = mc.major_id " +
            "LEFT JOIN course_info ci ON ci.id = mc.course_id " +
            "LEFT JOIN course_tea ct ON ci.id = ct.course_id " +
            "LEFT JOIN tea_info ti ON ti.id = ct.tea_id")
    //查询所有类别课程是否有老师任课
     List<CourseTeacherClassDto> getAllCourseTeacherClass(Page<CourseTeacherClassDto> page);
}

