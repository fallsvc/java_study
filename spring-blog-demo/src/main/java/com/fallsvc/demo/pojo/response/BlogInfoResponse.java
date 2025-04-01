package com.fallsvc.demo.pojo.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  22:48
 */
@Data
public class BlogInfoResponse {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    // JsonFormat 适用 Date LocalDateTime ,如果不用JsonFormat可以在get方法处理想要处理的数据
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createTime;

    // 如果要转换数据类型可以写在get方法中



}
