package com.fallsvc.demo.pojo.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/2  11:17
 */
@Data
public class UserLoginRequest {
    @NotNull(message = "用户名不能为空")
    private String username;
    @Length(max = 20,min = 5)
    @NotNull(message = "密码不能为空")
    private String password;
}
