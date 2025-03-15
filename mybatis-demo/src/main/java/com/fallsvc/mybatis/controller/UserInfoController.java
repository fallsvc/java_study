package com.fallsvc.mybatis.controller;

import com.fallsvc.mybatis.model.UserInfo;
import com.fallsvc.mybatis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/13  20:12
 */
@RequestMapping("/user")
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping("/getAllUser")
    public List<UserInfo> getAllUser(){
        return userInfoService.getAllUser();
    }
    @RequestMapping("/getAllUserById")
    public UserInfo getAllUserById(Integer id){
        return userInfoService.getAllUserById(id);
    }
    @RequestMapping("/login")
    public boolean loginByNameId(String userName,String password){
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername(userName);
        userInfo.setPassword(password);
        return userInfoService.getAllUserByPassword(userInfo);
    }
}
