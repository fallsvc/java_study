package com.fallsvc.book.model;

import lombok.Data;

import java.util.Date;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/16  23:00
 */
@Data
public class UserInfo {
    private Integer id;
    private String userName;
    private String password;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
