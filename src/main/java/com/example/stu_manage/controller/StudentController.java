package com.example.stu_manage.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.stu_manage.dto.StudentDto;
import com.example.stu_manage.entity.*;
import com.example.stu_manage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.R;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService; //学生
    @Autowired
    UserService userService; //用户
    @Autowired
    User_StudentService user_studentService;
    @Autowired
    Class_stuService class_stuService;
    @Autowired
    User_roleService user_roleService;
    @Autowired
    ScoreService scoreService;
    /* 根据id查询成绩 l */
    @GetMapping("/queryScoreById")
    public R queryOne(String page, String limit, Integer id) {
        R r = new R();
        Page<ScoreEntity> p = scoreService.queryScoreById(page, limit, id);
        r.put("code", 0);
        r.put("msg", "success");
        r.put("count", p.getTotal());
        r.put("data", p.getRecords());
        return r;
    }

    /* 根据id查询学生信息 l*/
    @GetMapping("/queryMesById")
    public StudentEntity queryById(Integer id) {
        return studentService.queryById(id);
    }

    /* 更新学生信息 l*/
    @PutMapping("/update")
    public String update(Integer id,String stu_phone,String stu_mail,String stu_address) {

        StudentEntity se = new StudentEntity();
        se.setStu_phone(stu_phone);
        se.setStu_address(stu_address);
        se.setStu_mail(stu_mail);

        studentService.update(se,id);
        return "true";
    }

    /* 新增一条学生的信息 l*/
    @PostMapping("/addOneStudent")
    public R addOnceStudent(@RequestBody StudentDto dto){
        System.out.println(dto.toString());

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStu_name(dto.getStu_name());
        studentEntity.setStu_age(dto.getStu_age());
        studentEntity.setStu_sex(dto.getStu_sex());
        studentEntity.setStu_phone(dto.getStu_phone());
        studentEntity.setStu_mail(dto.getStu_mail());
        studentEntity.setStu_address(dto.getStu_address());

        int sid = studentService.addOneStudent(studentEntity); //学生表id

        //向user表添加数据
        UserEntity user = new UserEntity();
        user.setUser_name(studentEntity.getStu_name());
        int uid = userService.addUser(user); //获得user表的uid

        //向user_stu表添加数据
        User_StudentEntity user_studentEntity = new User_StudentEntity();
        user_studentEntity.setSid(sid);
        user_studentEntity.setUid(uid);

        //user_stu表插入返回的id
        int id = user_studentService.addUserStudent(user_studentEntity);

        //向class_stu表添加数据
        Class_stuEntity class_stuEntity = new Class_stuEntity();
        class_stuEntity.setStu_id(sid);
        class_stuEntity.setClass_id(Integer.parseInt(dto.getClass_id()));
        int class_stu_id = class_stuService.addOneClass_stu(class_stuEntity);

        //向user_role表添加数据，分配角色
        User_roleEntity user_roleEntity = new User_roleEntity();
        user_roleEntity.setUser_id(uid);
        user_roleEntity.setRole_id(2);
        int user_role_id = user_roleService.addOneUser_role(user_roleEntity);

        System.out.println(sid + "," + uid + "," + id + "," + class_stu_id + "," + user_role_id);

        return R.ok();
    }

    /* 管理员查询所有学生信息*/
    @GetMapping("/getAllStudents")
    public R getAllStudents(String page, String limit){
        Page<StudentDto> pages = studentService.getAllStudents(page, limit);
        R r = new R();
        r.put("code", 0);
        r.put("count", pages.getTotal());
        r.put("data", pages.getRecords());
        r.put("msg", "success");
        return r;
    }

    /* 根据条件筛选学生 l*/
    @GetMapping("/getSomeStudents")
    public R getSomeStudents(String studentInfo,String page,String limit){
        Page<StudentDto> pages = studentService.getSomeStudents(studentInfo, page, limit);
        R r = new R();
        r.put("code", 0);
        r.put("count", pages.getTotal());
        r.put("data", pages.getRecords());
        r.put("msg", "success");
        return r;
    }

    //查询学生的各科成绩根据学号
    @GetMapping("/getStudentCourseScore")
    public  R getStudentCourseScore(String sid){
        System.out.println(studentService.getStudentCourseScore(Integer.parseInt(sid)));
        return  R.ok().put("data",studentService.getStudentCourseScore(Integer.parseInt(sid)));
    }
}
