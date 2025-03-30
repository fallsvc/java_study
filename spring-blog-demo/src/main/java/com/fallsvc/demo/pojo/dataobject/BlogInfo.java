package com.fallsvc.demo.pojo.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  21:24
 */
@Data
public class BlogInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Integer deleteFlag;
    private LocalDate createTime;
    private LocalDate updateTime;
}
