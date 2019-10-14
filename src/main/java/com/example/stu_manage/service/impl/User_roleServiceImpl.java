package com.example.stu_manage.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.stu_manage.dao.User_roleDao;
import com.example.stu_manage.entity.User_roleEntity;
import com.example.stu_manage.service.User_roleService;
import org.springframework.stereotype.Service;

@Service
public class User_roleServiceImpl extends ServiceImpl<User_roleDao, User_roleEntity> implements User_roleService {

    /* 为user添加一个角色*/
    @Override
    public int addOneUser_role(User_roleEntity user_roleEntity) {
        this.baseMapper.insert(user_roleEntity);
        return user_roleEntity.getId();
    }
}
