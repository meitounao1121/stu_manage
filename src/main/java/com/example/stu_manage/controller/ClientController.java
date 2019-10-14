package com.example.stu_manage.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.stu_manage.dto.Client_UserDto;
import com.example.stu_manage.dto.Major_CourseDto;
import com.example.stu_manage.entity.ClientEntity;
import com.example.stu_manage.entity.ScoreEntity;
import com.example.stu_manage.entity.UserEntity;
import com.example.stu_manage.service.ClientService;
import com.example.stu_manage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import util.AuthCode;
import util.R;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {

    @Autowired
    ClientService clientService;
    @Autowired
    UserService userService;
    /*@GetMapping("/queryById")
    public ClientEntity queryById(@RequestParam String params){
        return clientService.queryById(params);
    }*/
    @GetMapping("/test")
    public void test(String className,String nums){

    }

    @GetMapping(value="queryById/{params}")
    public ClientEntity queryById(@PathVariable("params") String params){
        return clientService.queryById(params);
    }

    @PostMapping("/login")
    public R login(@RequestBody UserEntity userEntity) {
        System.out.println(userEntity);
        /*boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
        if (!captcha) {
            return R.error("验证码不正确");
        }*/

        //用户信息
//        UserEntity user = userService.queryByName(userEntity.getUserName());

        //账号不存在、密码错误
//        if (user == null || !user.getPassWord().equals(userEntity.getPassWord())) {
//            return R.error("账号或密码不正确");
//        }

        //账号锁定
        /*if (user.getStatus() == 0) {
            return R.error("账号已被锁定,请联系管理员");
        }*/

        //生成token，并保存到数据库
        /*R r = sysUserTokenService.createToken(user.getUserId());
        return r;*/
        return R.ok().put("msg","登陆成功");
    }
    @GetMapping("/queryAll")
    public R queryAll(/*@RequestParam String params*/String page,String limit){
        //System.out.println(params);
        R r = new R();
        //Page<ClientEntity> p = clientService.queryAll(ParamsUtil.params2Map(params));
        Page<ClientEntity> p = clientService.queryAllG(page,limit);
        r.put("code", 0);
        r.put("msg", "success");
        r.put("count", p.getTotal());
        r.put("data", p.getRecords());
        return r;
    }

    @GetMapping("/imgcode")
    public void getImgcode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authCode = AuthCode.getAuthCode();
        HttpSession session = request.getSession();
        session.setAttribute("authCode", authCode);
        BufferedImage img = AuthCode.getAuthImg(authCode);
        ImageIO.write(img, "jpeg", response.getOutputStream()); //将二维码图片通过写出
    }
    @GetMapping("/qureyT")
    public R getA(){
        Page<Client_UserDto> p = clientService.getA();
        R r = new R();
        r.put("code", 0);
        r.put("msg", "success");
        r.put("count", p.getTotal());
        r.put("data", p.getRecords());
        return r;
    }
    @GetMapping("/skill")
    public R skill(String goods,int nums){
        return clientService.skill(goods,nums);
    }
    @GetMapping("setList")
    public R setList(String name,int nums){
        clientService.setList(name,nums);
        return R.ok();
    }
    @GetMapping("getcourse")
    public R getcourse(String page,String limit,String params){
        Page<Major_CourseDto> p = clientService.getcourse(page,limit,params);
        R r = new R();
        r.put("code", 0);
        r.put("msg", "success");
        r.put("count", p.getTotal());
        r.put("data", p.getRecords());
        return r;
    }
    @GetMapping("teagetscore")
    public R teagetscore(String page,String limit,String params){
        Page<ScoreEntity> p = clientService.teagetscore(page,limit,params);
        R r = new R();
        r.put("code", 0);
        r.put("msg", "success");
        r.put("count", p.getTotal());
        r.put("data", p.getRecords());
        return r;
    }
    @PutMapping("/editscore")
    public R editscore(@RequestBody ScoreEntity scoreEntity){
        //System.out.println(scoreEntity);
        boolean flag = clientService.updateScore(scoreEntity);
        if(flag){
            return R.ok("ok");
        }else {
            return R.error("failed");
        }
    }
}
