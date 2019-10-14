package com.example.stu_manage.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.stu_manage.dto.Sco_couDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 课程、分数DAO
 * 最后删除
 */

@Mapper
public interface Sco_couDao extends BaseMapper<Sco_couDto> {
    /* 查询学生某科的成绩 */
    @Select("select course_info.id, course_info.course_name, score.score " +
            "from score, course_info,user_stu u " +
            "WHERE score.course_id = course_info.id " +
            "AND u.sid = score.stu_id " +
            "and u.uid = #{id}")
    List<Sco_couDto> queryScoreById(Page<Sco_couDto> page, Integer id);

}
