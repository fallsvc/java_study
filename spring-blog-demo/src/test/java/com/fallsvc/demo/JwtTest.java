package com.fallsvc.demo;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import java.beans.Encoder;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/1  11:14
 */

public class JwtTest {
    @Test
    void getToken(){
//        Key key= Keys.hmacShaKeyFor("1233".getBytes(StandardCharsets.UTF_8));
        Key key= Keys.secretKeyFor(SignatureAlgorithm.HS256);
        Map<String,Object> map=new HashMap<>();
        map.put("id",1);
        map.put("name","张三");
        String token= Jwts.builder()
                .setClaims(map)
                .signWith(key)
                .compact();
        System.out.println(token);

        JwtParser jwtParser=Jwts.parserBuilder().setSigningKey(key).build();
        System.out.println(jwtParser.parse(token).getBody());

    }
    @Test
    void getKey(){
        Key key=Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String encode= Encoders.BASE64.encode(key.getEncoded());
        System.out.println(encode);
    }
}
