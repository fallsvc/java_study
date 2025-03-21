package com.fallsvc.book.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/7  11:02
 */
@Data
public class BookInfo {
    private Integer id;
    private String bookName;
    private String author;
    private Integer count;
    private BigDecimal price;
    private String publish;
    private Integer status;//0删除 1正常 2不可借阅
    private String statusCN;
    private Date createTime;
    private Date updateTime;
}
