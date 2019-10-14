package com.example.stu_manage.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.stu_manage.dao.Class_stuDao;
import com.example.stu_manage.dto.ClassStudentDto;
import com.example.stu_manage.entity.Class_stuEntity;
import com.example.stu_manage.service.Class_stuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Class_stuServiceImpl extends ServiceImpl<Class_stuDao, Class_stuEntity> implements Class_stuService {

    @Autowired
    Class_stuDao class_stuDao;
    @Override
    public int addOneClass_stu(Class_stuEntity class_stuEntity) {
        this.insert(class_stuEntity);
        return class_stuEntity.getId();
    }

    //查询班级对应的所有学生
    @Override
    public List<ClassStudentDto> getClassStudent(Integer cid) {

        return class_stuDao.getClassStudent(cid);
    }
}
