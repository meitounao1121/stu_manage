
package com.example.stu_manage.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.stu_manage.dto.PermissionDto;
import com.example.stu_manage.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SystemService extends IService<UserEntity> {
    UserEntity findByUsername(UserEntity userEntity);

    UserEntity findUserById(String userId);

    List<PermissionDto> getPermission(UserEntity userEntity);
}

