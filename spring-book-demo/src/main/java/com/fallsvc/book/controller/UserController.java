package com.fallsvc.book.controller;


import com.fallsvc.book.constant.Constants;
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

    /**
     *
     * @param name
     * @param password
     * @param session
     * @return true 密码正确 false 错误
     */
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
            userInfo.setPassword("");
            session.setAttribute(Constants.SESSION_USER_KEY,userInfo);
            return true;
        }
        return false;
    }
}
