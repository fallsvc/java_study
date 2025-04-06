package com.fallsvc.demo.pojo.response;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/6  15:13
 */
@Data
public class UserInfoResponse {
    private Integer id;
    private String userName;
    private String githubUrl;
}
