package com.example.stu_manage.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.stu_manage.dto.Sco_couDto;

/* 最后删除 */
public interface Sco_couService extends IService<Sco_couDto> {

    Page<Sco_couDto> queryScoreById(String pages, String limit, Integer id);

}
