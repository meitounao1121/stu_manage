package com.example.stu_manage.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.stu_manage.dao.StudentDao;
import com.example.stu_manage.dto.StudentCourseScoreDto;
import com.example.stu_manage.dto.StudentDto;
import com.example.stu_manage.entity.StudentEntity;
import com.example.stu_manage.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {

    @Resource
    StudentDao studentDao;

    /* 根据user_id连表查询学生信息 */
    @Override
    public StudentEntity queryById(Integer id) {
        return studentDao.queryById(id);
    }

    /**
     * 更新学生信息 l
     * @param studentEntity
     * @return
     */
    @Override
    public void update(StudentEntity studentEntity,Integer id) {
//        EntityWrapper<StudentEntity> wrapper = new EntityWrapper<>();
//        wrapper.eq("id", studentEntity.getId());
//
//        boolean update = this.update(studentEntity, wrapper);
        studentDao.update(studentEntity, id);

    }

    /**
     * 新增一条学生的信息，并返回老师的id
     * @param studentEntity
     * @return
     */
    @Override
    public int addOneStudent(StudentEntity studentEntity) {
        this.baseMapper.insert(studentEntity);
        return studentEntity.getId();
    }

    /**
     * 查询所有学生信息 l
     * @param page
     * @param limit
     * @return
     */
    @Override
    public Page<StudentDto> getAllStudents(String page, String limit) {
        Page<StudentDto> p = new Page<>();
        p.setSize(Integer.parseInt(limit));
        p.setCurrent(Integer.parseInt(page));
        p.setRecords(studentDao.getAllStudents(p));
        return p;
    }

    /**
     * 搜索查询学生信息
     * @param studentInfo
     * @return
     */
    @Override
    public Page<StudentDto> getSomeStudents(String studentInfo, String page, String limit) {
        Page<StudentDto> p = new Page<>();
        p.setSize(Integer.parseInt(limit));
        p.setCurrent(Integer.parseInt(page));
        p.setRecords(studentDao.getSomeStudents(p, studentInfo));
        return p;
    }

    @Override
    public List<StudentCourseScoreDto> getStudentCourseScore(Integer sid) {
        return studentDao.getStudentCourseScore(sid);
    }

}
