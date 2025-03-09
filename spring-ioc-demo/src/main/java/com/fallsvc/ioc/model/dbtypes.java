package com.fallsvc.ioc.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/9  18:06
 */

@ConfigurationProperties(prefix = "dbtypes")
@Configuration
@Data
public class dbtypes{
    private List<String> name;
    private Map<String,String> ball;
}
