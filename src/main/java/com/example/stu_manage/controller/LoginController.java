package com.example.stu_manage.controller;

import com.example.stu_manage.dto.PermissionDto;
import com.example.stu_manage.entity.UserEntity;
import com.example.stu_manage.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import util.AuthCode;
import util.R;
import util.TokenUtil;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/sys")
public class LoginController {
    @Autowired
    SystemService systemService;
    @Autowired
    HttpSession session;
    @Autowired
    RedisTemplate redisTemplate;
    //登陆验证 生成token 返回数据 z
    @PostMapping("/login")
    public R login(@RequestBody UserEntity userEntity){
        //验证验证码
        String code = session.getAttribute("authCode").toString();
        if (!code.equals(userEntity.getCode()))
            return R.error().put("message","验证码错误，请重试");
        //验证用户
        UserEntity userForBase=systemService.findByUsername(userEntity);
        if(userForBase==null){
            return R.error().put("message","登录失败,用户不存在");
        }else {
            if (!userForBase.getPassword().equals(userEntity.getPassword())){
                return R.error().put("message","登录失败,密码错误");
            }else {
                //登陆成功生成token返回
                String token = TokenUtil.getToken(userForBase);
                boolean absentBoolean = redisTemplate.opsForValue().setIfAbsent("token"+userForBase.getId(),token);
                System.out.println(absentBoolean);
                if (!absentBoolean)
                redisTemplate.opsForValue().getAndSet("token"+userForBase.getId(),token);
                List<PermissionDto> list = systemService.getPermission(userForBase);
                return R.ok().put("token", token).put("user", userForBase).put("message","登陆成功").put("permission",list);
            }
        }
    }
    //验证码 z
    @GetMapping("/imgcode")
    public void getImgcode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authCode = AuthCode.getAuthCode();
        HttpSession session = request.getSession();
        session.setAttribute("authCode", authCode);
        BufferedImage img = AuthCode.getAuthImg(authCode);
        ImageIO.write(img, "jpeg", response.getOutputStream());
    }

}
