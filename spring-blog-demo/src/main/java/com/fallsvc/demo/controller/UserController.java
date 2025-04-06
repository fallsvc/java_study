package com.fallsvc.demo.controller;

import com.fallsvc.demo.pojo.request.UserLoginRequest;
import com.fallsvc.demo.pojo.response.UserInfoResponse;
import com.fallsvc.demo.pojo.response.UserLoginResponse;
import com.fallsvc.demo.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  22:27
 */
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;
    @RequestMapping("/login")
    public UserLoginResponse login(@RequestBody @Validated UserLoginRequest userLoginRequest){
        log.info("用户登录：{}",userLoginRequest);
        return userService.checkPassword(userLoginRequest);
    }
    @RequestMapping("/getUserInfo")
    public UserInfoResponse getUserInfo(@NotNull(message = "用户id不能为null") Integer userId){
        log.info("获得用户信息，userId："+userId);
        return userService.getUserInfo(userId);
    }
    @RequestMapping("/getAuthorInfo")
    public UserInfoResponse getAuthorInfo(@NotNull(message = "blogid不能为null") Integer blogId){
        log.info("获得作者信息，blogId ："+blogId);
        return userService.getAuthorInfo(blogId);
    }
}
