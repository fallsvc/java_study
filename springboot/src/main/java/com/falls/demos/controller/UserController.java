package com.falls.demos.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/4  20:59
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public boolean login(String userName,String password,HttpSession session){
        // 参数校验
        if(!StringUtils.hasLength(userName)||!StringUtils.hasLength(password)){
            return false;
        }
        //这里不处理数据库
        // "admin".equals(userName) 不会报空指针异常
        if("admin".equals(userName)&&"123456".equals(password)){
            //
            session.setAttribute("userName",userName);
            return true;
        }

        return false;
    }
    @RequestMapping("/getLoginUserName")
    public String getLoginUserName(HttpSession session){
        String userName=(String)session.getAttribute("userName");

        return "用户名为："+userName;
    }
}
