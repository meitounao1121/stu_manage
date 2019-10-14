package com.example.stu_manage.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.stu_manage.dao.ScoreDao;
import com.example.stu_manage.entity.ScoreEntity;
import com.example.stu_manage.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreDao, ScoreEntity> implements ScoreService {

    @Autowired
    ScoreDao scoreDao;

    @Override
    public Page<ScoreEntity> queryScoreById(String pages, String limit, Integer id) {
        Page<ScoreEntity> page = new Page<>();
        page.setSize(Integer.parseInt(limit));
        page.setCurrent(Integer.parseInt(pages));
        page.setRecords(scoreDao.queryScoreById(page, id));

        return page;
    }
}
