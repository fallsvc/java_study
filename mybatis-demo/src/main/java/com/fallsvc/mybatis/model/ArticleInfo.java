package com.fallsvc.mybatis.model;

import lombok.Data;

import java.util.Date;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/14  22:47
 */
@Data
public class ArticleInfo {
    private Integer id;
    private String title;
    private String content;
    private Integer uid;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
    private String username;
    private Integer age;
}
