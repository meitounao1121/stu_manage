package com.example.stu_manage.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.stu_manage.dao.Sco_couDao;
import com.example.stu_manage.dto.Sco_couDto;
import com.example.stu_manage.service.Sco_couService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/* 最后删除 */
@Service
public class Sco_couServiceImpl extends ServiceImpl<Sco_couDao, Sco_couDto> implements Sco_couService {

    @Resource
    Sco_couDao sco_couDao;

    @Override
    public Page<Sco_couDto> queryScoreById(String pages, String limit, Integer id) {
        Page<Sco_couDto> page = new Page<>();
        page.setSize(Integer.parseInt(limit)); //给page这个对象设置每页的数量
        page.setCurrent(Integer.parseInt(pages)); //设置页数
        page.setRecords(sco_couDao.queryScoreById(page, id)); //设置通过dao查询到的记录

        return page;
    }
}
