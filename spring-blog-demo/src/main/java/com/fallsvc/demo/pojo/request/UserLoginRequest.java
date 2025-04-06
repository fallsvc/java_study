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

    @NotNull(message = "密码不能为空")
    @Length(max = 20,min = 5,message = "密码长度必须在5-20")
    private String password;
}
