package com.example.stu_manage.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.stu_manage.dto.ClassStudentDto;
import com.example.stu_manage.entity.Class_stuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Class_stuDao extends BaseMapper<Class_stuEntity> {
        //查询班级对应的所有学生
    @Select("SELECT ci.id AS cid," +
            "class_name AS class_name," +
            "si.id AS sid," +
            "si.stu_name " +
            "FROM class_stu cs,class_info ci,stu_info si " +
            "WHERE cs.stu_id = si.id AND cs.class_id = ci.id " +
            "AND ci.id = #{cid} " +
            "GROUP BY si.id")
    List<ClassStudentDto> getClassStudent(Integer cid);
}
