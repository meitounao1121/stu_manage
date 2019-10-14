package com.example.stu_manage.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.stu_manage.dto.TeacherDto;
import com.example.stu_manage.entity.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TeacherDao extends BaseMapper<TeacherEntity> {

    //查询所有老师信息
    @Select("SELECT  t.id,u.user_name,u.password,t.tea_age,t.tea_email,t.tea_sex,t.tea_phone,t.tea_address "+
            "FROM user u,tea_info t,user_tea ut "+
            "WHERE t.id = ut.tid "+
            "AND ut.uid = u.id")
    List<TeacherDto> getAllTeachers(Page<TeacherDto> page) ;

    //根据输入信息筛选老师
    List<TeacherDto> getSomeTeachers(String teacherInfo);

    //新增老师信息
    Integer addOneTeacher(TeacherEntity teacherEntity);

    //查询所有老师姓名和id
    @Select("SELECT id ,tea_name  FROM tea_info  WHERE tea_name IS NOT NULL")
    List<TeacherEntity> getTeacherNameAndId();

    //查询未当班主任的老师的姓名和id
    @Select("SELECT ti.id,ti.tea_name " +
            "FROM tea_info ti WHERE ti.id " +
            "NOT IN(SELECT tea_id FROM class_tea) " +
            "AND ti.tea_name IS NOT NULL")
    List<TeacherEntity> getTeacherNameId();

    /* 更新老师的信息 l*/
    @Update("UPDATE tea_info tea,user,user_tea u " +
            "SET tea.tea_phone = #{teacherEntity.tea_phone},tea.tea_email =#{teacherEntity.tea_email}, tea.tea_address= #{teacherEntity.tea_address} " +
            "WHERE tea.id = u.tid AND `user`.id = u.uid " +
            "AND user.id = ${id}")
    void update(TeacherEntity teacherEntity,Integer id);

    /* 查询学生信息 l*/
    @Select("SELECT tea.tea_name,tea.tea_phone,tea.tea_email,tea.tea_address,`user`.`password` " +
            "FROM tea_info tea, user, user_tea " +
            "WHERE tea.id = user_tea.tid " +
            "AND `user`.id = user_tea.uid " +
            "AND user.id = #{id}")
    TeacherEntity queryMesById(Integer id);
}
