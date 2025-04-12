package com.fallsvc.demo;

import com.fallsvc.demo.common.utils.SecurityUtil;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/12  20:57
 */
public class MD5Test {
    @Test
    public void encrypt(){
        String password="123456";
        String salt= UUID.randomUUID().toString().replace("-","");
        System.out.println(salt);

        String s2 = DigestUtils.md5DigestAsHex((salt+password ).getBytes(StandardCharsets.UTF_8));

        System.out.println(s2);
    }

    @Test
    public void decrypt(){
        String dataBaseP="9a79445b8ba3c119668542600938f2d4262863f6bbd245fb87ff826604a0da98";
        String password="123456";

        String salt=dataBaseP.substring(32,64);

        String s=DigestUtils.md5DigestAsHex((password+salt).getBytes(StandardCharsets.UTF_8));
        System.out.println(dataBaseP.equals(s+salt));
    }
    @Test
    public void test1(){
        String encrypt = SecurityUtil.encrypt("123456");
        System.out.println(SecurityUtil.verify("123456", encrypt));

    }
}
