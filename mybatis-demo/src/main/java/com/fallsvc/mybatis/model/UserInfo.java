package com.fallsvc.mybatis.model;

import lombok.Data;

import java.util.Date;


/**
 * @auther falls_vc
 * description:
 * @date 2025/3/13  11:09
 */
@Data
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Integer gender;
    private String phone;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
