package com.fallsvc.mybatis.mapper;

import com.fallsvc.mybatis.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/14  20:48
 */
@SpringBootTest
public class UserInfoMapperXMLTest {
    @Autowired
    private UserInfoMapperXML userInfoMapperXML;

    @Test
    void selectAll() {
        userInfoMapperXML.selectAll().stream().forEach(x-> System.out.println(x));
    }

    @Test
    void insertUser() {
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername("asdd");
        userInfo.setAge(3);
        userInfo.setPassword("password3");
        userInfoMapperXML.insertUser(userInfo);
        System.out.println(userInfo.getId());
    }

    @Test
    void deleteUser() {
        UserInfo userInfo=new UserInfo();
        userInfo.setId(9);
        userInfoMapperXML.deleteUser(userInfo);
    }

    @Test
    void updateUser() {
        UserInfo userInfo=new UserInfo();
        userInfo.setId(5);
        userInfo.setPhone("15310929591");
        userInfoMapperXML.updateUser(userInfo);
    }
}
