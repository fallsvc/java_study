package com.fallsvc.aop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/26  11:03
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/u1")
    public boolean u1(){
        log.info("u1 ....");
        return false;
    }
}
