package com.fallsvc.demo.pojo.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/12  10:26
 */
@Data
public class UpdateBlogRequest {
    @NotNull(message = "用户id不能为null")
    private Integer userId;
    @NotBlank(message = "标题不能为空")
    private String title;
    @NotBlank(message = "内容不能为空")
    private String content;
}
