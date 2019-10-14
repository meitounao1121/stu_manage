package com.example.stu_manage.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.stu_manage.dto.StudentCourseScoreDto;
import com.example.stu_manage.dto.StudentDto;
import com.example.stu_manage.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {

    /*查询学生信息*/
    @Select("SELECT stu.stu_name,stu.stu_phone,stu.stu_mail,stu.stu_address,`user`.`password` " +
            "FROM stu_info stu, user, user_stu " +
            "WHERE stu.id = user_stu.sid " +
            "AND `user`.id = user_stu.uid " +
            "AND user.id = #{id}")
    StudentEntity queryById(Integer id);

    /*更新学生信息*/
    @Update("UPDATE stu_info stu,user,user_stu u " +
            "SET stu.stu_phone = #{studentEntity.stu_phone},stu.stu_mail = #{studentEntity.stu_mail},stu.stu_address= #{studentEntity.stu_address}" +
            "WHERE stu.id = u.sid AND `user`.id = u.uid " +
            "AND user.id = ${id}")
    void update(StudentEntity studentEntity,Integer id);

    /*查询所有学生信息*/
    @Select("SELECT us.uid as id,s.stu_name,ur.password,s.stu_age,s.stu_mail,s.stu_sex,s.stu_phone,s.stu_address,ci.class_name " +
            "FROM class_info ci RIGHT JOIN class_stu cs ON ci.id = cs.class_id " +
            "RIGHT JOIN stu_info s ON s.id = cs.stu_id  LEFT JOIN user_stu us ON s.id = us.sid " +
            "LEFT JOIN user ur ON ur.id = us.uid")
    List<StudentDto> getAllStudents(Page<StudentDto> page);

    @Select("SELECT s.id,s.stu_name,ur.password,s.stu_age,s.stu_mail,s.stu_sex,s.stu_phone,s.stu_address,ci.class_name " +
            "FROM class_info ci RIGHT JOIN class_stu cs ON ci.id = cs.class_id " +
            "RIGHT JOIN stu_info s ON s.id = cs.stu_id  LEFT JOIN user_stu us ON s.id = us.sid " +
            "LEFT JOIN user ur ON ur.id = us.uid " +
            "WHERE s.stu_name LIKE concat('%',concat(#{studentInfo}),'%')" +
            "OR s.stu_sex LIKE concat('%',concat(#{studentInfo}),'%')" +
            "OR s.stu_age LIKE concat('%',concat(#{studentInfo}),'%')" +
            "OR s.stu_phone LIKE concat('%',concat(#{studentInfo}),'%')" +
            "OR s.stu_mail LIKE concat('%',concat(#{studentInfo}),'%')" +
            "OR s.stu_address LIKE concat('%',concat(#{studentInfo}),'%')" +
            "OR ci.class_name LIKE concat('%',concat(#{studentInfo}),'%')" +
            "GROUP BY s.id" )
    /*根据条件查询学生并分页*/
    List<StudentDto> getSomeStudents(Page<StudentDto> page, String studentInfo);


    @Select("SELECT si.id AS sid,si.stu_name,ci.id AS cid,ci.course_name,sco.score " +
            "FROM score sco,stu_info si,course_info ci,course_tea ct " +
            "WHERE  sco.stu_id = si.id  " +
            "AND sco.course_tea_id =ct.id " +
            "AND ct.course_id = ci.id " +
            "AND si.id = #{sid} " +
            "GROUP BY ci.course_name")
    //查询某位同学的各科成绩
    List<StudentCourseScoreDto> getStudentCourseScore(Integer sid);
}
