package com.example.stu_manage.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.stu_manage.entity.UserEntity;

public interface UserService extends IService<UserEntity> {
    UserEntity queryByName(String userName);

    //添加用户信息
    int addUser(UserEntity userEntity);

    //修改用户密码信息
    boolean updatePassword(UserEntity userEntity);
}
