package com.fallsvc.mybatis.mapper;

import com.fallsvc.mybatis.model.UserInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/13  11:19
 */
@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Test
    void selectAll() {
        System.out.println(userInfoMapper.selectAll());
    }

    @BeforeEach
    void setUp() {
        System.out.println("before...........");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after...........");
    }

    @Test
    void testSelectAll() {
        System.out.println(userInfoMapper.selectAllById(2));
    }

    @Test
    void insertUser() {
        UserInfo userInfo=new UserInfo();
        userInfo.setAge(20);
        userInfo.setUsername("www");
        userInfo.setPassword("111");
        System.out.println("影响行数"+userInfoMapper.insertUser(userInfo));;
    }

    @Test
    void insertUser2() {
        UserInfo userInfo=new UserInfo();
        userInfo.setAge(20);
        userInfo.setUsername("wwwaaa");
        userInfo.setPassword("111");
        System.out.println("影响行数"+userInfoMapper.insertUser(userInfo));;
    }

    @Test
    void deleteUser() {
        userInfoMapper.deleteUser(6);
    }

    @Test
    void updateUser() {
        UserInfo userInfo=new UserInfo();
        userInfo.setId(1);
        userInfo.setDeleteFlag(1);
        userInfoMapper.updateUser(userInfo);
    }
}