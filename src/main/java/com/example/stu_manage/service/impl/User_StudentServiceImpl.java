package com.example.stu_manage.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.stu_manage.dao.User_StudentDao;
import com.example.stu_manage.entity.User_StudentEntity;
import com.example.stu_manage.service.User_StudentService;
import org.springframework.stereotype.Service;

@Service
public class User_StudentServiceImpl extends ServiceImpl<User_StudentDao, User_StudentEntity> implements User_StudentService {

    //user_stu 关系表的插入 l
    @Override
    public int addUserStudent(User_StudentEntity user_studentEntity) {
        this.baseMapper.insert(user_studentEntity);
        return user_studentEntity.getId();
    }
}
