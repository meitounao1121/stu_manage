package com.example.stu_manage.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.stu_manage.dao.Class_stuDao;
import com.example.stu_manage.dto.ClassTeacherDto;
import com.example.stu_manage.entity.ClassTeacherEntity;
import com.example.stu_manage.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.R;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    ClassService classService;

    @Autowired
    Class_stuDao class_stuDao;

    /* 查询所有班级（行政班）*/
    @GetMapping("/getAllClass")
    public R getAllClass() {
        return R.ok().put("data",classService.getAllClass());
    }


    //查询班级对应班主任
    @GetMapping("/getClassTeacher")
    public R getClassTeacher(String page,String limit){
        Page<ClassTeacherDto> pa = classService.getClassTeacher(page,limit);

        R r = new R();
        r.put("code",0);
        r.put("data", pa.getRecords());
        r.put("count",pa.getTotal());
        r.put("msg","success");

        return r;
    }

    //查询没有班主任的班级
    @GetMapping("/getClassWithNoTeacher")
    public  R getClassWithNoTeacher(){
        return R.ok().put("data",classService.getClassWithNoTeacher());
    }


    //为某一个班级分配班主任
    @PostMapping("/addClassTeacher")
    public  R addClassTeacher(@RequestBody ClassTeacherEntity classTeacherEntity){
        int i  = classService.addClassTeacher(classTeacherEntity);
        if(i>0)
           return  R.ok();
      return   R.error();
    }


    //查看班主任所管理的班级编号及名称 以及班级人数
    @GetMapping("/getTeacherClass")
    public R getTeacherClass(String page,String limit,String id){
        Page<ClassTeacherDto> pa = classService.getTeacherClass(page,limit,Integer.parseInt(id));
        R r = new R();

        r.put("code",0);
        r.put("msg","success");
        r.put("data", pa.getRecords());
        r.put("count",pa.getTotal());
        System.out.println(id);
            return r;

    }


    //查询班级所对应的所有学生
    @GetMapping("/getClassStudent")
    public R getClassStudent(String cid){
        System.out.println(class_stuDao.getClassStudent(Integer.parseInt(cid)));
        return R.ok().put("data",class_stuDao.getClassStudent(Integer.parseInt(cid)));
    }
}
