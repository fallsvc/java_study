package com.fallsvc.book.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/24  22:37
 */
@RequestMapping("/test")
@RestController
public class TestController {
    @RequestMapping("/t1")
    public void t1(){
        int x=1/0;
        return ;
    }
}
