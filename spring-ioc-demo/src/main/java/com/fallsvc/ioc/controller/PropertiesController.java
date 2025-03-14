package com.fallsvc.ioc.controller;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/9  12:45
 */
@RequestMapping("/prop")
@ResponseBody
@Controller
public class PropertiesController {
    @Value("${my.key}")
    private String myKey;

    @RequestMapping("/read")
    public String readValue(){
        System.out.println("读取配置文件my.key="+myKey);
        return myKey;
    }

    /**
     * 初始化注解
     */
    @PostConstruct
    public void init(){

    }
}
