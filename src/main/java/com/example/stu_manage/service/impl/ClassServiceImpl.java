package com.example.stu_manage.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.stu_manage.dao.ClassDao;
import com.example.stu_manage.dao.ClassTeacherDao;
import com.example.stu_manage.dto.ClassTeacherDto;
import com.example.stu_manage.entity.ClassEntity;
import com.example.stu_manage.entity.ClassTeacherEntity;
import com.example.stu_manage.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl extends ServiceImpl<ClassDao, ClassEntity> implements ClassService {


    @Autowired
    ClassDao classDao;

    @Autowired
    ClassTeacherDao classTeacherDao;

    @Override
    public List<ClassEntity> getAllClass() {
        return this.selectList(new EntityWrapper<ClassEntity>());
    }

    //查询所有班级对应的班主任
    @Override
    public Page<ClassTeacherDto> getClassTeacher(String page, String limit) {
        Page<ClassTeacherDto> p = new Page<>();

        p.setSize(Integer.parseInt(limit));
        p.setCurrent(Integer.parseInt(page));

        p.setRecords(classDao.getClassTeacher(p));
        return p;
    }

    //查询没有班主任的班级
    @Override
    public List<ClassEntity> getClassWithNoTeacher() {
        return classDao.getClassWithNoTeacher();
    }

    //为某一个班级添加班主任
    @Override
    public int addClassTeacher(ClassTeacherEntity classTeacherEntity) {
       classTeacherDao.insert(classTeacherEntity);
        return classTeacherEntity.getId();
    }

    //查看班主任所管理的 班级的名称编号 学生人数
    @Override
    public Page<ClassTeacherDto> getTeacherClass(String page,String limit,Integer id) {
        Page<ClassTeacherDto> p = new Page<>();

        p.setSize(Integer.parseInt(limit));
        p.setCurrent(Integer.parseInt(page));

        p.setRecords(classDao.getTeacherClass(p,id));
        return p;
    }


}
