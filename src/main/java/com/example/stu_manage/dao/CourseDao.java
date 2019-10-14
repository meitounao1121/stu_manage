package com.example.stu_manage.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.stu_manage.dto.CourseStudentDto;
import com.example.stu_manage.dto.CourseStudentScoreDto;
import com.example.stu_manage.dto.Major_CourseDto;
import com.example.stu_manage.entity.CourseEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseDao extends BaseMapper<CourseEntity> {
    @Select("SELECT ct.id,major_name,course_name,t.tea_name,ct.course_class,ct.deadline FROM course_tea ct " +
            "LEFT JOIN course_info c ON c.id = ct.course_id " +
            "LEFT JOIN tea_info t ON t.id = ct.tea_id " +
            "LEFT JOIN major_course mc ON c.id = mc.course_id " +
            "LEFT JOIN major_info m ON m.id = mc.major_id " +
            "WHERE major_id = #{p} GROUP BY ct.id")
    List<Major_CourseDto> getCourseByMajor(Page<Major_CourseDto> pages,int p);

    @Select("SELECT ci.id,ci.course_name " +
            "FROM major_course mc,course_info ci " +
            "WHERE mc.course_id = ci.id " +
            "AND mc.major_id = #{major_id}")
    //查询类别对应的课程
    List<CourseEntity> getCourseByMajorId(int major_id);
    @Select("SELECT ct.id,major_name,course_name,t.tea_name,ct.course_class,ct.course_time,ct.course_place FROM course_tea ct " +
            "LEFT JOIN course_info c ON c.id = ct.course_id " +
            "LEFT JOIN tea_info t ON t.id = ct.tea_id " +
            "LEFT JOIN major_course mc ON c.id = mc.course_id " +
            "LEFT JOIN major_info m ON m.id = mc.major_id " +
            "LEFT JOIN ct_s cts ON cts.ct_id = ct.id " +
            "LEFT JOIN stu_info s ON cts.stu_id = s.id " +
            "LEFT JOIN user_stu us ON us.sid = s.id " +
            "LEFT JOIN user u ON us.uid = u.id " +
            "WHERE u.id = #{uid} GROUP BY ct.id")
    List<Major_CourseDto> getCourseByUid(Page<Major_CourseDto> pages, int uid);


    //查询任课老师所教课程班级 班级名 人数
    @Select("SELECT ct.id AS ctid,mi.major_name,ci.course_name AS course_name,ct.course_class AS course_class,COUNT(cts.ct_id) AS Q " +
            "FROM course_tea ct " +
            "LEFT JOIN course_info ci ON ci.id = ct.course_id " +
            "LEFT JOIN tea_info ti ON ti.id = ct.tea_id " +
            "LEFT JOIN major_course mc ON ci.id = mc.course_id " +
            "LEFT JOIN major_info mi ON mi.id = mc.major_id " +
            "LEFT JOIN user_tea ut ON ut.tid = ti.id " +
            "LEFT JOIN USER u ON ut.uid = u.id " +
            "LEFT JOIN ct_s cts ON cts.ct_id = ct.id " +
            "WHERE u.id = #{uid} GROUP BY ct.id")
    List<CourseStudentDto> getCourseStudent(Integer uid);

    //查询某个课程班级的学生的成绩
    @Select("SELECT ct.id AS ctid,ci.course_name,ct.course_class,si.id AS sid,si.stu_name,s.score " +
            "FROM score s,stu_info si,course_tea ct,course_info ci " +
            "WHERE s.course_tea_id = #{ctid} " +
            " AND s.course_tea_id = ct.id " +
            " AND ct.course_id = ci.id " +
            " AND s.stu_id = si.id " +
            " GROUP BY si.id")
    List<CourseStudentScoreDto> getCourseStudentScore(Integer ctid);
}
