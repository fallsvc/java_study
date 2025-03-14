package com.fallsvc.mybatis.service;

import com.fallsvc.mybatis.mapper.UserInfoMapper;
import com.fallsvc.mybatis.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/13  20:12
 */
@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public List<UserInfo> getAllUser() {
        return userInfoMapper.selectAll();
    }

    public UserInfo getAllUserById(Integer n) {
        return userInfoMapper.selectAllById(n);
    }
}
