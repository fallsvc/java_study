package com.falls.demos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/6  10:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageInfo {
    private Integer id;
    private String from;
    private String to;
    private String message;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;

}
