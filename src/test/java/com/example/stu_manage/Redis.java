package com.example.stu_manage;

import com.alibaba.fastjson.JSON;
import com.example.stu_manage.entity.ClassEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Redis {
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;
    @Test
    public void RedisTest(){
        ClassEntity classEntity = new ClassEntity();
        classEntity.setClass_name("三十三");
        classEntity.setId(1);
        redisTemplate.opsForValue().set("班级",classEntity);
    }
    @Test
    public void ListTest(){
        List<ClassEntity> list = new ArrayList();
        list.add(new ClassEntity(1,"sansh"));
        list.add(new ClassEntity(2,"萨乌丁我"));
        redisTemplate.opsForValue().set("tlist",list);
    }
}
