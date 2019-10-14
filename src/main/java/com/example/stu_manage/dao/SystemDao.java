package com.example.stu_manage.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.stu_manage.dto.PermissionDto;
import com.example.stu_manage.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemDao extends BaseMapper<UserEntity> {
    List<PermissionDto> getPermiss(Integer id);
}
