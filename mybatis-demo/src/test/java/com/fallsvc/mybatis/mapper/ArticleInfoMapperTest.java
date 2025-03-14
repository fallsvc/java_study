package com.fallsvc.mybatis.mapper;

import com.fallsvc.mybatis.model.ArticleInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/14  22:54
 */
@SpringBootTest
class ArticleInfoMapperTest {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void selectArticleInfoById() {
        System.out.println(articleInfoMapper.selectArticleInfoById(1));
    }
}