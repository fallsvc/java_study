package com.fallsvc.ioc.controller;

import com.fallsvc.ioc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/8  20:39
 */
@Controller
public class HelloController {
    // DI 依赖注入
    //1属性注入
//    @Autowired
//    private UserService userService;


//    private UserService userService;
//    // 2构造方法注入
//    public HelloController(){
//
//    }
//
//    /**
//     * Autowired 默认注入方法
//     * @param userService
//     */
//    @Autowired
//    public HelloController(UserService userService){
//        this.userService=userService;
//    }

    // setter注入
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService=userService;
    }
    public void print(){
        System.out.println("do Controller");
        userService.test();
    }
}
