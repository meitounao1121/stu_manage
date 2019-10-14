package com.example.stu_manage.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.stu_manage.dto.ClassTeacherDto;
import com.example.stu_manage.dto.TeacherDto;
import com.example.stu_manage.entity.ClassEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassDao extends BaseMapper<ClassEntity> {
    //查询所有班级是否有班主任
    @Select("SELECT ci.id AS cid," +
            "ci.class_name," +
            "ti.id AS tid," +
            "ti.tea_name," +
            "COUNT(*) AS classQ  " +
            "FROM class_info ci " +
            "LEFT JOIN class_tea ct ON ci.id = ct.class_id " +
            "LEFT JOIN tea_info ti ON ti.id = ct.tea_id " +
            "LEFT JOIN class_stu  cs ON ci.id = cs.class_id GROUP BY ci.id")
    List<ClassTeacherDto> getClassTeacher(Page<ClassTeacherDto> page);

    //查询所有班级信息
    @Select("SELECT id,class_name FROM class_info")
    List<ClassEntity> getAllClassInfo();

    //查询没有班主任的班级
    @Select("SELECT ci.id,ci.class_name " +
            "FROM class_info  ci WHERE  " +
            "ci.id NOT IN(" +
            "SELECT class_id FROM class_tea GROUP BY class_id);")
    List<ClassEntity> getClassWithNoTeacher();

    //查看班主任所管理的班级 班级名称和编号 班级人数
    @Select("SELECT  ct.class_id as cid,class_name,ti.tea_name,COUNT(*) AS ClassQ  " +
            "FROM class_info ci," +
            "tea_info ti," +
            "class_tea ct," +
            "user_tea ut," +
            "USER u," +
            "class_stu cs " +
            "WHERE cs.class_id = ct.class_id " +
            "AND ci.id = ct.class_id " +
            "AND ct.tea_id = ti.id " +
            "AND ti.id = ut.tid " +
            "AND ut.uid = u.id " +
            "AND u.id = #{id} " +
            "group by ct.class_id")
    List<ClassTeacherDto> getTeacherClass(Page<ClassTeacherDto> page,Integer id);


}
