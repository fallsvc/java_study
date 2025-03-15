package com.fallsvc.mybatis.mapper;

import com.fallsvc.mybatis.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/14  20:24
 */
@Mapper
public interface UserInfoMapperXML {

    List<UserInfo> selectAll();
    Integer insertUser(@Param("userInfo") UserInfo userInfo);
    Integer deleteUser(UserInfo userInfo);
    Integer updateUser(UserInfo userInfo);

    Integer insertUser2(UserInfo userInfo);
}
