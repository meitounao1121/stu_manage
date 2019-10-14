package com.example.stu_manage.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.stu_manage.dao.MajorDao;
import com.example.stu_manage.dto.CourseTeacherClassDto;
import com.example.stu_manage.entity.MajorEntity;
import com.example.stu_manage.service.MajorService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl extends ServiceImpl<MajorDao, MajorEntity> implements MajorService {

    @Autowired
    MajorDao majorDao;
    @Override
    public List<MajorEntity> getMajor() {
        return this.selectList(new EntityWrapper<MajorEntity>());
    }

    //查询所有类别课程是否有老师任课
    @Override
    public Page<CourseTeacherClassDto> getAllCourseTeacherClass(String page,String limit) {
        Page<CourseTeacherClassDto> p = new Page<>();

        p.setSize(Integer.parseInt(limit));
        p.setCurrent(Integer.parseInt(page));

        p.setRecords(majorDao.getAllCourseTeacherClass(p));

        return p;
    }
}
