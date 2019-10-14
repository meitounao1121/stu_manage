package com.example.stu_manage.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.stu_manage.dao.UserDao;
import com.example.stu_manage.entity.UserEntity;
import com.example.stu_manage.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
    @Override
    public UserEntity queryByName(String userName) {
        return this.selectOne(new EntityWrapper<UserEntity>()
        .eq("stu_name",userName));
    }


    //新增用户信息
    @Override
    public int addUser(UserEntity userEntity) {
        this.baseMapper.insert(userEntity);
        return userEntity.getId();
    }

    //修改用户密码
    @Override
    public boolean updatePassword(UserEntity userEntity) {
        boolean flag = this.update(userEntity,new EntityWrapper<UserEntity>().eq("id",userEntity.getId()));
        return flag;
    }
}
