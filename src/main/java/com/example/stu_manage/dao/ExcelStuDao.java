package com.example.stu_manage.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.stu_manage.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExcelStuDao extends BaseMapper<StudentEntity> {
}
