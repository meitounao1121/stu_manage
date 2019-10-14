package com.example.stu_manage.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.stu_manage.entity.ScoreEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScoreDao extends BaseMapper<ScoreEntity> {

    @Select("SELECT ct.id,ci.course_name,s.score " +
            "FROM score s,course_info ci,course_tea ct,user_stu u " +
            "WHERE ci.id = ct.course_id " +
            "AND s.course_tea_id = ct.id " +
            "AND u.sid = s.stu_id " +
            "AND u.uid = #{id}")
    List<ScoreEntity> queryScoreById(Page<ScoreEntity> page, Integer id);
}
