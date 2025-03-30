package com.fallsvc.trans.service;

import com.fallsvc.trans.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public Integer registryUser(String name,String password){
         //插⼊⽤⼾信息
        return userInfoMapper.insert(name,password);
    }
}