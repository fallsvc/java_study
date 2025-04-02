package com.fallsvc.demo.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import java.beans.Encoder;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/2  10:47
 */
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
        JwtParser jwtParser=Jwts.parserBuilder().setSigningKey(key).build();

        Claims claims=jwtParser.parseClaimsJws(token).getBody();
        return claims;
    }

}
