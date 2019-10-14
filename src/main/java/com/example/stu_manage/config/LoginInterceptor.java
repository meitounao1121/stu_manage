
package com.example.stu_manage.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.stu_manage.entity.UserEntity;
import com.example.stu_manage.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    SystemService systemService;
    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        if (token == null) {
            //httpServletResponse.sendRedirect("error.html");
            //throw new MyException("500","用户在别处登陆");
            throw new RuntimeException("无token，请重新登录");
        }
        // 获取 token 中的 user id
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            //httpServletResponse.sendRedirect("error.html");
            //throw new MyException("500","用户在别处登陆");
            throw new RuntimeException("401");
        }
        UserEntity user = systemService.findUserById(userId);
        if (user == null) {

            //throw new MyException("500","用户在别处登陆");
            throw new RuntimeException("用户不存在，请重新登录");
        }
        //System.out.println("val:"+token);
        //System.out.println("val2:"+redisTemplate.opsForValue().get("token"+userId).toString());
        if (!redisTemplate.opsForValue().get("token"+userId).toString().equals(token)) {

            throw new RuntimeException("用户在别处登陆");
        }
            //throw new MyException("500","用户在别处登陆");
                // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            //httpServletResponse.sendError(500,"用户在别处登陆");
            //throw new MyException("500","用户在别处登陆");
            throw new RuntimeException("401");
            }
            return true;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
