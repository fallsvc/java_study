package com.fallsvc.demo.pojo.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

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
    private LocalDate createTime;
}
