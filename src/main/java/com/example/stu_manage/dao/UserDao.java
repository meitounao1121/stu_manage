package com.example.stu_manage.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.stu_manage.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
    //修改用户
    int updateUser(UserEntity userEntity);

    //新增用户信息
    int addUser(UserEntity userEntity);

}
