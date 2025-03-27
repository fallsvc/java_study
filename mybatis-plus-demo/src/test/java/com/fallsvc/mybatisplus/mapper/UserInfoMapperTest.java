package com.fallsvc.mybatisplus.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/21  23:40
 */
@SpringBootTest
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Test
    void selectAll() {
        userInfoMapper.selectAll().stream().forEach(System.out::println);
    }
}