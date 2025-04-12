package com.fallsvc.demo.common.utils;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/12  23:29
 */
public class SecurityUtil {
    /**
     * 密码
     * @param password
     * @return 盐值+md5(盐值+明文)
     */
    public static String encrypt(String password){
        String salt= UUID.randomUUID().toString().replace("-","");
        String securityPassword = DigestUtils.md5DigestAsHex((salt+password).getBytes(StandardCharsets.UTF_8));
        return salt+securityPassword;
    }

    /**
     * 验证
     * @param inputPassword
     * @param sqlPassword
     * @return
     */

    public static boolean verify(String inputPassword,String sqlPassword){
        if(!StringUtils.hasLength(inputPassword)) return false;
        if(sqlPassword==null||sqlPassword.length()!=64){
            return false;
        }

        String salt=sqlPassword.substring(0,32);
        String securityPassword=DigestUtils.md5DigestAsHex((salt+inputPassword).getBytes(StandardCharsets.UTF_8));
        return sqlPassword.equals(salt+securityPassword);
    }
}
