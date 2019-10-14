package com.example.stu_manage.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.stu_manage.dto.CourseTeacherClassDto;
import com.example.stu_manage.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import util.R;

import java.util.List;

@RestController
public class MajorController {

    @Autowired
    MajorService majorService;
    @GetMapping("/getCourseTeacherClass")
    public R getAllCourseTeacherClass(String page,String limit){

        System.out.println("getcourseTeacherClass");
        System.out.println(majorService.getAllCourseTeacherClass(page,limit));
        Page<CourseTeacherClassDto> pa = majorService.getAllCourseTeacherClass(page,limit);
        System.out.println(pa.getRecords());
        R r = new R();
        r.put("code",0);
        r.put("msg","success");
        r.put("count",pa.getTotal());
        r.put("data",pa.getRecords());

        return r;
    }
}
