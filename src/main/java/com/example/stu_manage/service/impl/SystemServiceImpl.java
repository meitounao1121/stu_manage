package com.example.stu_manage.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.stu_manage.dao.SystemDao;
import com.example.stu_manage.dto.PermissionDto;
import com.example.stu_manage.entity.UserEntity;
import com.example.stu_manage.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemServiceImpl extends ServiceImpl<SystemDao, UserEntity> implements SystemService {

    //通过姓名查询用户
    @Override
    public UserEntity findByUsername(UserEntity userEntity) {
        return this.selectOne(new EntityWrapper<UserEntity>()
        .eq("user_name",userEntity.getUser_name()));
    }
    //通过id查询用户
    @Override
    public UserEntity findUserById(String userId) {
        return this.selectOne(new EntityWrapper<UserEntity>()
                .eq("id",userId));
    }
    //查询用户功能列表
    @Override
    public List<PermissionDto> getPermission(UserEntity userEntity) {
        return this.baseMapper.getPermiss(userEntity.getId());
    }

}
