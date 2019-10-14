package com.example.stu_manage.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.stu_manage.controller.EasyPoiExcelController;
import com.example.stu_manage.dao.CourseDao;
import com.example.stu_manage.dao.Course_Teacher_StuDao;
import com.example.stu_manage.dao.ScoreDao;
import com.example.stu_manage.dao.User_StuDao;
import com.example.stu_manage.dto.CourseStudentDto;
import com.example.stu_manage.dto.CourseStudentScoreDto;
import com.example.stu_manage.dto.Major_CourseDto;
import com.example.stu_manage.entity.CourseEntity;
import com.example.stu_manage.entity.Course_Teacher_StuEntity;
import com.example.stu_manage.entity.ScoreEntity;
import com.example.stu_manage.entity.User_StuEntity;
import com.example.stu_manage.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import util.R;

import java.util.List;

@Service
@Scope("prototype")
public class CourseServiceImpl extends ServiceImpl<CourseDao,CourseEntity> implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private User_StuDao user_stuDao;
    @Autowired
    private Course_Teacher_StuDao course_teacher_stuDao;
    @Autowired
    private ScoreDao scoreDao;
    @Autowired
    private RedisTemplate redisTemplate;

    private static final Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Override
    public Page<Major_CourseDto> getCourseByMajor(String page, String limit, String params) {
        //设置page对象
        Page<Major_CourseDto> pages = new Page<>();
        pages.setCurrent(Integer.parseInt(page));
        pages.setSize(Integer.parseInt(limit));
        int p = Integer.parseInt(params);
        String res = "";
        String res2 ="";
        //获取Dto_list添加remain 值list大小
        List<Major_CourseDto> list = courseDao.getCourseByMajor(pages,p);
        for (int i = 0 ; i < list.size() ; i++) {
            try {
                res2 = redisTemplate.opsForList().size(list.get(i).getCourse_class()+"").toString();
                res = res2.equals("0")? "选课已满":res2;
            }catch (Exception e){
                res = "选课已满";
            }finally {
                //设置remain值
                list.get(i).setRemain(res);
            }
        }
        //System.out.println(list);
        pages.setRecords(list);
        return pages;
    }

    @Override
    public R skill(int ctid, int uid, String course_class) {
        if (redisTemplate.opsForSet().add("user","\""+ctid+"_"+uid+"\"")==0L)
            return R.error("选课失败，不能重复选课");
        //处理前端课程名
        String str = course_class.replace("\"", "");
        String res = str.substring(0,str.length()-2);
        if (redisTemplate.opsForSet().add("course",res+uid)==0L)
            return R.error("选课失败，不能重复选择同一学科");
        //判断当前库存 大于1允许选课
        Long num = redisTemplate.opsForList().size(str);
        if(1<=num){
            Object obj = redisTemplate.opsForList().leftPop(str);
            try {
                if((int) obj >= 1){
                    User_StuEntity user_stuEntity = new User_StuEntity();
                    ScoreEntity scoreEntity = new ScoreEntity();
                    Course_Teacher_StuEntity course_teacher_stuEntity = new Course_Teacher_StuEntity();
                    user_stuEntity.setUid(uid);
                    //根据uid查询sid
                    User_StuEntity user_stuEntity1 = user_stuDao.selectOne(user_stuEntity);
                    int stuId = user_stuEntity1.getSid();
                    course_teacher_stuEntity.setCt_id(ctid);
                    course_teacher_stuEntity.setStu_id(stuId);
                    System.out.println((int) obj+"选课成功");
                    //更具uid sid插入ct_s表
                    course_teacher_stuDao.insert(course_teacher_stuEntity);
                    //更具sid.ctid插入score表
                    scoreEntity.setCourse_tea_id(ctid);
                    scoreEntity.setStu_id(stuId);
                    //System.out.println(scoreEntity);
                    scoreDao.insert(scoreEntity);
                    log.info("插入成功");
                    return R.ok("选课成功");
                }
            }catch (Exception e){
                log.info("抢完了=========================");
                return R.error("选课失败");
            }
            //return ((int) obj) > 1?R.ok("选课成功"):R.error("选课失败");
        }
        log.info("选课失败====================");
        return R.error("选课失败");
    }

    @Override
    public List<CourseEntity> getCourseByMajorId(int major_id) {

        return courseDao.getCourseByMajorId(major_id);
    }

    @Override
    public R test() {
        return redisTemplate.opsForSet().add("user","1_9")==1L?R.ok():R.error();
    }

    @Override
    public Page<Major_CourseDto> gethooseCourse(String page, String limit, String params) {
        //设置page对象
        Page<Major_CourseDto> pages = new Page<>();
        pages.setCurrent(Integer.parseInt(page));
        pages.setSize(Integer.parseInt(limit));
        int p = Integer.parseInt(params);
        //获取Dto_list添加remain 值list大小
        List<Major_CourseDto> list = courseDao.getCourseByUid(pages,p);
        pages.setRecords(list);
        return pages;
    }

    //查询任课老师所教课程班级 班级人数
    @Override
    public List<CourseStudentDto> getCourseStudent(Integer uid) {
        return courseDao.getCourseStudent(uid);
    }

    //查询课程班级所有学生的成绩
    @Override
    public List<CourseStudentScoreDto> getCourseStudentScore(Integer ctid) {
        return courseDao.getCourseStudentScore(ctid);
    }
}
