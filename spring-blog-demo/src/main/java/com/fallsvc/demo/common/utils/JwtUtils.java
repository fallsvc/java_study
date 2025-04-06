package com.fallsvc.demo.common.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Map;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/2  10:47
 */
@Slf4j
public class JwtUtils {
//
    private static String SECRET_STRING="0Aj+Dv38aiVdI+vQqy3RftfwhGsQPHt+0gGVxV/xu8k=";
//    private static Key key=Keys.hmacShaKeyFor(SECRET_STRING.getBytes(StandardCharsets.UTF_8));
    private static Key key=Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_STRING));


    public static String getToken(Map<String,Object> claims){
        String token= Jwts.builder()
                .setClaims(claims)
                .signWith(key)
                .compact();
        return token;
    }


    public static Claims parseToken(String token){
        if(!StringUtils.hasLength(token)) return null;

        JwtParser jwtParser=Jwts.parserBuilder().setSigningKey(key).build();

        Claims claims= null;
        try {
            claims = jwtParser.parseClaimsJws(token).getBody();
        } catch (Exception e) {
            log.info("token解析失败：{}",token);
        }
        return claims;
    }
}
