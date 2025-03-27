package com.fallsvc.ioc.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/9  17:52
 */
// 从配置中读取
@ConfigurationProperties(prefix = "person")
@Configuration
@Data
public class Person {
    private Integer id;
    private String name;
    private String age;

}
