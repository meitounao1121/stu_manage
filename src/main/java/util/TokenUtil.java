package util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.stu_manage.entity.UserEntity;

import java.util.Date;

public class TokenUtil {
    public static String getToken(UserEntity user) {
        String token="";
        Date date = new Date(System.currentTimeMillis()+60000*30);
        token= JWT.create().withAudience(user.getId().toString())
                .withExpiresAt(date)
                .sign(Algorithm.HMAC256(user.getPassword()));
        System.out.println(token);
        return token;
    }
}
