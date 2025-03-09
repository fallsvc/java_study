package com.fallsvc.book.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/7  11:02
 */
@Data
public class BookInfo {
    private Integer bookId;
    private String bookName;
    private String author;
    private Integer num;
    private BigDecimal price;
    private String publish;
    private Integer status;
    private String statusCN;
}
