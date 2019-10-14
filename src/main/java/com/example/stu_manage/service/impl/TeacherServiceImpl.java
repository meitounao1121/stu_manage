package com.example.stu_manage.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.example.stu_manage.dao.CourseTeacherDao;
import com.example.stu_manage.dto.TeacherDto;
import com.example.stu_manage.entity.CourseTeacherEntity;
import com.example.stu_manage.entity.TeacherEntity;
import com.example.stu_manage.service.TeacherService;
import com.example.stu_manage.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, TeacherEntity> implements TeacherService {

    //查询所有老师信息
    @Resource
    TeacherDao teacherDao;
    //
    @Resource
    CourseTeacherDao courseTeacherDao;
    @Override
    public Page<TeacherDto> getAllTeachers(String page,String limit) {
        Page<TeacherDto> p = new Page<>();

        p.setSize(Integer.parseInt(limit));
        p.setCurrent(Integer.parseInt(page));

        p.setRecords(teacherDao.getAllTeachers(p));
        return p;
    }

    //搜索查询老师信息
    @Override
    public List<TeacherDto> getSomeTeachers(String teacherInfo) {

        return teacherDao.getSomeTeachers(teacherInfo);
    }

    //新增一条老师信息 并返回老师id值
    @Override
    public int addOneTeacher(TeacherEntity teacherEntity) {
        this.baseMapper.insert(teacherEntity);
        return teacherEntity.getId();
    }

    //查询老师姓名和id
    @Override
    public List<TeacherEntity> getTeacherNameAndId() {
        return teacherDao.getTeacherNameAndId();
    }

    //course_tea表添加课程对应的任教老师
    @Override
    public int addCourseTeacher(CourseTeacherEntity courseTeacherEntity) {
        int i = 0;
        i = courseTeacherDao.insert(courseTeacherEntity);
        return i;
    }

    //查询未当班主任的老师的姓名和id
    @Override
    public List<TeacherEntity> getTeacherNameId() {
        return teacherDao.getTeacherNameId();
    }


    /**
     * 更新老师信息 l
     * @param teacherEntity
     * @param id
     */
    @Override
    public void update(TeacherEntity teacherEntity, Integer id) {
        teacherDao.update(teacherEntity, id);
    }

    /**
     * 查询学生信息
     * @param id
     * @return
     */
    @Override
    public TeacherEntity queryMesById(Integer id) {
        return teacherDao.queryMesById(id);
    }


}
