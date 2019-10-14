package com.example.stu_manage.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.stu_manage.entity.ScoreEntity;

public interface ScoreService extends IService<ScoreEntity> {

    Page<ScoreEntity> queryScoreById(String pages, String limit, Integer id);
}
