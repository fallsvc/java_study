package com.fallsvc.book.service;

import com.fallsvc.book.mapper.UserInfoMapper;
import com.fallsvc.book.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/16  23:12
 */
@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public UserInfo queryUserInfoByName(String username){
        return userInfoMapper.queryUserInfoByName(username);
    }

}
