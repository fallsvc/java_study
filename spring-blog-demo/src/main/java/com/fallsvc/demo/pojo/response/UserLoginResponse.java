package com.fallsvc.demo.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/2  11:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponse {
    private Integer id;
    private String token;
}
