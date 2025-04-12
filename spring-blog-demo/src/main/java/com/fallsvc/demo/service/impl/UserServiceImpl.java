package com.fallsvc.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fallsvc.demo.common.exception.BlogException;
import com.fallsvc.demo.common.utils.BeanTransUtils;
import com.fallsvc.demo.common.utils.JwtUtils;
import com.fallsvc.demo.common.utils.SecurityUtil;
import com.fallsvc.demo.mapper.UserInfoMapper;
import com.fallsvc.demo.pojo.dataobject.BlogInfo;
import com.fallsvc.demo.pojo.dataobject.UserInfo;
import com.fallsvc.demo.pojo.request.UserLoginRequest;
import com.fallsvc.demo.pojo.response.UserInfoResponse;
import com.fallsvc.demo.pojo.response.UserLoginResponse;
import com.fallsvc.demo.service.BlogService;
import com.fallsvc.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  22:28
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private BlogService blogService;

    @Override
    public UserLoginResponse checkPassword(UserLoginRequest userLoginRequest) {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getDeleteFlag,0)
                .eq(UserInfo::getUserName,userLoginRequest.getUsername());
        UserInfo userInfo=userInfoMapper.selectOne(queryWrapper);
        if(userInfo==null) throw new BlogException("用户名不存在");

//        if(!userInfo.getPassword().equals(userLoginRequest.getPassword())){
//            throw new BlogException("密码错误");
//        }
        // MD5检测
        if(!SecurityUtil.verify(userLoginRequest.getPassword(),userInfo.getPassword())){
            log.info(userLoginRequest.getPassword()+" "+userInfo.getPassword());
            throw new BlogException("密码错误");
        }
        // 登录成功
        Map<String,Object> map=new HashMap<>();
        map.put("id",userInfo.getId());
        map.put("name",userInfo.getUserName());
        String token= JwtUtils.getToken(map);

        return new UserLoginResponse(userInfo.getId(),token);
    }

    @Override
    public UserInfoResponse getUserInfo(Integer userId) {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getDeleteFlag,0)
                .eq(UserInfo::getId,userId);
        UserInfo userInfo=userInfoMapper.selectOne(queryWrapper);

        return BeanTransUtils.trans(userInfo);
    }

    @Override
    public UserInfoResponse getAuthorInfo(Integer blogId) {
        // 1.根据博客id查询博客信息
        BlogInfo blogInfo=blogService.getBlogInfoByBlogId(blogId);
        if(blogInfo==null||blogInfo.getUserId()<=0){
            throw new BlogException("博客不存在");
        }
        // 2.根据userId 查询user信息
        return getUserInfo(blogInfo.getUserId());
    }
}
