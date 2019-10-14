package com.example.stu_manage.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.stu_manage.dao.ClientDao;
import com.example.stu_manage.dao.ScoreDao;
import com.example.stu_manage.dto.Client_UserDto;
import com.example.stu_manage.dto.Major_CourseDto;
import com.example.stu_manage.entity.ClientEntity;
import com.example.stu_manage.entity.ScoreEntity;
import com.example.stu_manage.entity.UserEntity;
import com.example.stu_manage.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import util.R;

import java.util.List;
import java.util.Map;

@Service
public class ClientServiceImpl extends ServiceImpl<ClientDao, ClientEntity> implements ClientService {
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private ScoreDao scoreDao;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    private static final Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Override
    public ClientEntity queryById(String params) {
        return this.selectById(params);
    }

    @Override
    public Page<ClientEntity> queryAll(Map<String, Object> map){
        Page<ClientEntity> page = new Page<>();
        page.setSize(Integer.parseInt(map.get("limit").toString()));
        page.setCurrent(Integer.parseInt(map.get("page").toString()));
        return this.selectPage(page);
    }

    @Override
    public Page<ClientEntity> queryAllG(String pages, String limit) {
        Page<ClientEntity> page = new Page<>();
        page.setSize(Integer.parseInt(limit));
        page.setCurrent(Integer.parseInt(pages));
        return this.selectPage(page);
    }

    @Override
    public ClientEntity queryTest() {
        return this.selectOne(new EntityWrapper<ClientEntity>()
                .eq("client_id",1));
    }

    @Override
    public Page<Client_UserDto> getA() {
        Page<Client_UserDto> page = new Page<>();
        page.setSize(30);
        page.setCurrent(1);
        page.setRecords(clientDao.getA(page));

        return page;
    }

    @Override
    public R skill(String goods, int buy) {
        /*int num = (int) redisTemplate.opsForValue().get(goods);

        if (buy<=num) {
            redisTemplate.opsForValue().increment(goods,-(buy));
            System.out.println("nums:"+num+"选课成功");
            return R.ok("选课成功");
        }else{
            System.out.println("nums:"+num+"选课失败");
            return R.error("选课失败");
        }*/
        //return redisTemplate.opsForValue().increment(goods,-(buy))>=1L?R.ok("选课成功"):R.error("选课失败");

        Long num = redisTemplate.opsForList().size(goods);
        if(buy<=num){
            Object obj = redisTemplate.opsForList().leftPop(goods);
            try {
                if((int) obj >= 1){
                    log.info((int) obj+"选课成功");
                    return R.ok("选课成功");
                }
            }catch (Exception e){
                log.info("================抢完了");
                return R.error("选课失败");
            }
            //return ((int) obj) > 1?R.ok("选课成功"):R.error("选课失败");
        }
        log.info(num+"选课失败");
        return R.error("选课失败");
    }

    @Override
    public void setList(String name,int num) {
        for (int i = 0; i < num; i++) {
            redisTemplate.opsForList().leftPush(name,i);
        }
    }

    @Override
    public Page<Major_CourseDto> getcourse(String page, String limit, String params) {
        //设置page对象
        Page<Major_CourseDto> pages = new Page<>();
        pages.setCurrent(Integer.parseInt(page));
        pages.setSize(Integer.parseInt(limit));
        int p = Integer.parseInt(params);
        //获取Dto_list添加remain 值list大小
        List<Major_CourseDto> list = clientDao.getCourseByUid(pages,p);
        pages.setRecords(list);
        return pages;
    }

    @Override
    public Page<ScoreEntity> teagetscore(String page, String limit, String params) {
        Page<ScoreEntity> pages = new Page<>();
        pages.setCurrent(Integer.parseInt(page));
        pages.setSize(Integer.parseInt(limit));
        int p = Integer.parseInt(params);
        //获取Dto_list添加remain 值list大小
        List<ScoreEntity> list = clientDao.teagetscore(pages,p);
        System.out.println(list);
        pages.setRecords(list);
        return pages;
    }

    @Override
    public boolean updateScore(ScoreEntity scoreEntity) {
        return scoreDao.update(scoreEntity,new EntityWrapper<ScoreEntity>()
                .eq("course_tea_id",scoreEntity.getCourse_tea_id())
                .eq("stu_id",scoreEntity.getStu_id()))==1;
    }
}
