package com.fallsvc.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/20  21:23
 */

/**
 * 默认对应大小驼峰 UserInfo -- user_info
 *                 deleteFlag - delete_flag
 */
@Data
@TableName("user_info")
public class UserInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userName;
    private String password;
    @TableField("delete_flag")
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
