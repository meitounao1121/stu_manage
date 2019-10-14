package com.example.stu_manage.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.stu_manage.dto.Major_CourseDto;
import com.example.stu_manage.service.CourseService;
import com.example.stu_manage.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.R;

@RestController
@RequestMapping("/course")
@Scope("prototype")
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    MajorService majorService;
    //测试接口
    @GetMapping("/test")
    public R getCourseByMajor(){
        return courseService.test();
    }
    //获取major数据
    @GetMapping("/getmajor")
    public R getmajor(){
        return R.ok().put("major",majorService.getMajor());
    }
    //根据类别属性查询对应的所有课程
    @GetMapping("/getCourseByMajor")
    public R getCourseByMajor(String page,String limit,String params){
        Page<Major_CourseDto> p = courseService.getCourseByMajor(page,limit,params);
        R r = new R();
        r.put("code", 0);
        r.put("msg", "success");
        r.put("count", p.getTotal());
        r.put("data", p.getRecords());
        return r;
    }
    //选课功能
    @GetMapping("/chooseCourse")
    public R chooseCourse(String ctid,String uid,String course_class){
        return courseService.skill(Integer.parseInt(ctid),Integer.parseInt(uid),course_class);
    }

    //根据类别属性查询对应的所有课程

    @GetMapping("/getCourseByMajorId")
    public R getCourseByMajorId(String major_id){
        System.out.println(major_id);
        int major_id1 = Integer.parseInt(major_id);
        return R.ok().put("data",courseService.getCourseByMajorId(major_id1));
    }
    @GetMapping("/gethooseCourse")
    public R gethooseCourse(String page,String limit,String params){
        Page<Major_CourseDto> p = courseService.gethooseCourse(page,limit,params);
        R r = new R();
        r.put("code", 0);
        r.put("msg", "success");
        r.put("count", p.getTotal());
        r.put("data", p.getRecords());
        return r;
    }

    //查询任课老师所教课程对应的班级 以及班级人数
    @GetMapping("/getCourseStudent")
    public R getCourseStudent(String uid){
        Integer uid1 = Integer.parseInt(uid);
        System.out.println(courseService.getCourseStudent(uid1));
        return R.ok().put("data",courseService.getCourseStudent(uid1));
    }

    //查看所教课程班级的学生成绩
    @GetMapping("/getCourseStudentScore")
    public R getCourseStudentScore(String ctid){
        Integer ctid1 = Integer.parseInt(ctid);
        System.out.println(courseService.getCourseStudentScore(ctid1));
        return R.ok().put("data",courseService.getCourseStudentScore(ctid1));

    }

}
