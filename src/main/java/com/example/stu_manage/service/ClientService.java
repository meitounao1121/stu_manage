package com.example.stu_manage.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.stu_manage.dto.Client_UserDto;
import com.example.stu_manage.dto.Major_CourseDto;
import com.example.stu_manage.entity.ClientEntity;
import com.example.stu_manage.entity.ScoreEntity;
import util.R;

import java.util.List;
import java.util.Map;

public interface ClientService extends IService<ClientEntity> {
    ClientEntity queryById(String params);

    Page<ClientEntity> queryAll(Map<String, Object> stringObjectMap);

    Page<ClientEntity> queryAllG(String page, String limit);

    ClientEntity queryTest();

    Page<Client_UserDto> getA();

    R skill(String goods, int nums);

    void setList(String name,int num);

    Page<Major_CourseDto> getcourse(String page, String limit, String params);

    Page<ScoreEntity> teagetscore(String page, String limit, String params);

    boolean updateScore(ScoreEntity scoreEntity);
}
