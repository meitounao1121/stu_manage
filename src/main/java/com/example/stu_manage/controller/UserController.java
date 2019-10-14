package com.example.stu_manage.controller;

import com.example.stu_manage.entity.UserEntity;
import com.example.stu_manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import util.R;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    //修改密码的接口 Y
    @PutMapping("/editPassword")
    public R editPassword(@RequestBody UserEntity userEntity){
//        System.out.println(userEntity);
        boolean flag = userService.updatePassword(userEntity);
        if(flag){
            return R.ok("ok");
        }else {
            return R.error("failed");
        }
    }
}
