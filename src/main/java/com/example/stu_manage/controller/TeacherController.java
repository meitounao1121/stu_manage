package com.example.stu_manage.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.stu_manage.dto.TeacherDto;
import com.example.stu_manage.entity.*;
import com.example.stu_manage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.R;


@RestController
public class TeacherController {
    @Autowired
    //老师
    TeacherService teacherService;
    //用户
    @Autowired
    UserService userService;
    //user-teacher
    @Autowired
    User_TeacherService user_teacherService;
    //班级
    @Autowired
    ClassService classService;
    @Autowired
    User_roleService user_roleService;
    @Autowired
    ClientService clientService;
    //管理员查询所有老师信息
    @GetMapping("/getAllTeachers")
    public R getAllTeacher(String page,String limit){
        System.out.println(page+","+limit);
        System.out.println("getAll");
        Page<TeacherDto> pa = teacherService.getAllTeachers(page,limit);
        R r = new R();
        r.put("code",0);
        r.put("count",pa.getTotal());
        r.put("data",pa.getRecords());
        r.put("msg","success");
        return r;
    }

    //根据条件筛选老师
    @GetMapping("/getSomeTeachers")
    public R getSomeTeacher(String teacherInfo){
        System.out.println(teacherInfo);
        return R.ok().put("data",teacherService.getSomeTeachers(teacherInfo));
    }

    //新增一条一条老师的信息
    @PostMapping("/addOneTeacher")
    public R addOneTeacher(@RequestBody TeacherEntity teacherEntity){
        System.out.println(teacherEntity.toString());
        int tid = teacherService.addOneTeacher(teacherEntity);//teacher表id

        UserEntity user = new UserEntity() ;
        user.setUser_name(teacherEntity.getTea_name());

        int uid = userService.addUser(user);//用户表id

        User_TeacherEntity user_teacherEntity = new User_TeacherEntity();
        user_teacherEntity.setTid(tid);
        user_teacherEntity.setUid(uid);

        //user_tea表插入返回的id
        int id = user_teacherService.addUserTeacher(user_teacherEntity);

        //向user_role表添加数据，分配角色
        User_roleEntity user_roleEntity = new User_roleEntity();
        user_roleEntity.setUser_id(uid);
        user_roleEntity.setRole_id(3);
        int user_role_id = user_roleService.addOneUser_role(user_roleEntity);

        System.out.println(tid + "," + uid + "," + id + "," + user_role_id);
        return R.ok();
    }
    //查询老师姓名和Id
    @GetMapping("/getTeacherNameAndId")
    public  R getTeacherNameAndId(){
        System.out.println("getNameAndID");
        System.out.println(teacherService.getTeacherNameAndId());
        return R.ok().put("data",teacherService.getTeacherNameAndId());
    }

    //课程对应的任教老师
    @PostMapping("/addCourseTeacher")
    public  R addCourseTeacher(@RequestBody CourseTeacherEntity courseTeacherEntity){
        System.out.println("addcourse+teacher");
        String count = courseTeacherEntity.getMaxCount();
        String course_class = courseTeacherEntity.getCourse_class();
        //设置课程容纳人数
        clientService.setList(course_class,Integer.parseInt(count));
        int i = teacherService.addCourseTeacher(courseTeacherEntity);
        if(i>0)
           return R.ok();
        return R.error();
    }

    //查询未当班主任的老师的姓名和id
    @GetMapping("/getTeacherNameId")
    public R getTeacherNameId(){
        return R.ok().put("data",teacherService.getTeacherNameId());
    }

    /* 更新老师信息 l*/
    @PutMapping("/teacher/update")
    public String update(Integer id,String tea_phone,String tea_email,String tea_address){
        TeacherEntity te = new TeacherEntity();
        te.setTea_phone(tea_phone);
        te.setTea_address(tea_address);
        te.setTea_email(tea_email);

        teacherService.update(te, id);
        return "true";
    }

    /* 根据id查询老师信息 */
    @GetMapping("/teacher/queryMesById")
    public TeacherEntity queryMesById(Integer id){
        return teacherService.queryMesById(id);
    }
}
