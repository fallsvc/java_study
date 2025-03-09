package com.fallsvc.book.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/7  11:05
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String name, String password, HttpSession session){
        //
        if(!StringUtils.hasLength(name)||!StringUtils.hasLength(password)){
            return false;
        }
        // 未学数据库操作，写死密码
        if("admin".equals(name)&&"123456".equals(password)){
            session.setAttribute("userName",name);
            return true;
        }
        return false;
    }
}
