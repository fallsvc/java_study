package com.fallsvc.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fallsvc.demo.common.exception.BlogException;
import com.fallsvc.demo.common.utils.JwtUtils;
import com.fallsvc.demo.mapper.UserInfoMapper;
import com.fallsvc.demo.pojo.dataobject.UserInfo;
import com.fallsvc.demo.pojo.request.UserLoginRequest;
import com.fallsvc.demo.pojo.response.UserLoginResponse;
import com.fallsvc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  22:28
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserLoginResponse checkPassword(UserLoginRequest userLoginRequest) {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getDeleteFlag,0)
                .eq(UserInfo::getUserName,userLoginRequest.getUsername());
        UserInfo userInfo=userInfoMapper.selectOne(queryWrapper);
        if(userInfo==null) throw new BlogException("用户名不存在");

        if(!userInfo.getPassword().equals(userLoginRequest.getPassword())){
            throw new BlogException("密码错误");
        }
        // 登录成功
        Map<String,Object> map=new HashMap<>();
        map.put("id",userInfo.getId());
        map.put("name",userInfo.getUserName());
        String token= JwtUtils.getToken(map);

        return new UserLoginResponse(userInfo.getId(),token);
    }
}
