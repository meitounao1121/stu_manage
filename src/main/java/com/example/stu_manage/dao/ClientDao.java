package com.example.stu_manage.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.stu_manage.dto.Client_UserDto;
import com.example.stu_manage.dto.Major_CourseDto;
import com.example.stu_manage.entity.ClientEntity;
import com.example.stu_manage.entity.ScoreEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ClientDao extends BaseMapper<ClientEntity> {
    @Select("SELECT * FROM client INNER JOIN baseuser")
    List<Client_UserDto> getA(Page page);

    @Select("SELECT ct.id,major_name,course_name,ct.course_class,ct.course_time,ct.course_place FROM course_tea ct " +
            "LEFT JOIN course_info c ON c.id = ct.course_id " +
            "LEFT JOIN tea_info t ON t.id = ct.tea_id " +
            "LEFT JOIN major_course mc ON c.id = mc.course_id " +
            "LEFT JOIN major_info m ON m.id = mc.major_id " +
            "LEFT JOIN user_tea ut ON ut.tid = t.id " +
            "LEFT JOIN user u ON ut.uid = u.id " +
            "WHERE u.id = #{uid} GROUP BY ct.id")
    List<Major_CourseDto> getCourseByUid(Page<Major_CourseDto> pages, int p);
    @Select("SELECT si.id,si.stu_name,course_class,score FROM stu_info si " +
            "LEFT JOIN score s ON s.stu_id = si.id " +
            "LEFT JOIN ct_s cts ON cts.ct_id = s.course_tea_id " +
            "LEFT JOIN course_tea ct ON ct.id = cts.ct_id " +
            "LEFT JOIN user_tea ut ON ut.tid = ct.tea_id " +
            "LEFT JOIN user u ON ut.uid = u.id " +
            "WHERE u.id = #{p} GROUP BY s.id")
    List<ScoreEntity> teagetscore(Page<ScoreEntity> pages, int p);
}
