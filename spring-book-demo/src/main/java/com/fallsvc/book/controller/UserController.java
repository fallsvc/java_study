package com.fallsvc.book.controller;


import com.fallsvc.book.model.UserInfo;
import com.fallsvc.book.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public Boolean login(String name, String password, HttpSession session){
        //
        if(!StringUtils.hasLength(name)||!StringUtils.hasLength(password)){
            return false;
        }
        // 未学数据库操作，写死密码
//        if("admin".equals(name)&&"123456".equals(password)){
//            session.setAttribute("userName",name);
//            return true;
//        }
        // 根据用户名获取用户信息
        UserInfo userInfo=userService.queryUserInfoByName(name);
        if(userInfo==null){
            return false;
        }
        if(password.equals(userInfo.getPassword())){
            session.setAttribute("session_user_info",userInfo);
            return true;
        }
        return false;
    }
}
