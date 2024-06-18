package com.example.letseventdemo.api.component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.letseventdemo.api.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${security.jwt.secret-key}")
    private String secretKey;


    public String generateJWT(User user) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        Calendar c = Calendar.getInstance();
        Date today = new Date();
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date expires = c.getTime();
        String token = JWT.create().withExpiresAt(expires).withSubject(user.getUserName()).sign(algorithm);
        return token;
    }

    public String getUsername(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token).getSubject();
    }

    public boolean validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        try {
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
