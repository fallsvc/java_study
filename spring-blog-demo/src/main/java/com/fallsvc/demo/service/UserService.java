package com.fallsvc.demo.service;

import com.fallsvc.demo.pojo.request.UserLoginRequest;
import com.fallsvc.demo.pojo.response.UserInfoResponse;
import com.fallsvc.demo.pojo.response.UserLoginResponse;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  22:33
 */
public interface UserService {
    UserLoginResponse checkPassword(UserLoginRequest userLoginRequest);

    UserInfoResponse getUserInfo(Integer userId);

    UserInfoResponse getAuthorInfo(Integer blogId);
}
