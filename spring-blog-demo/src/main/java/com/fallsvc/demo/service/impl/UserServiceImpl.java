package com.fallsvc.demo.service.impl;

import com.fallsvc.demo.pojo.request.UserLoginRequest;
import com.fallsvc.demo.pojo.response.UserLoginResponse;
import com.fallsvc.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  22:28
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public UserLoginResponse checkPassword(UserLoginRequest userLoginRequest) {

        return null;
    }
}
