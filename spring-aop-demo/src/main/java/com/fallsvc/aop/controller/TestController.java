package com.fallsvc.aop.controller;

import com.fallsvc.aop.aspect.MyAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/26  11:02
 */
@Slf4j
@RequestMapping("/test")
@RestController
public class TestController {
    @MyAspect
    @RequestMapping("/t1")
    public String t1(){
        log.info("t1 执行");

        return "";
    }
}
