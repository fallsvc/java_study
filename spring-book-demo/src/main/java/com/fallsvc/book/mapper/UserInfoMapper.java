package com.fallsvc.book.mapper;

import com.fallsvc.book.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/16  23:09
 */
@Mapper
public interface UserInfoMapper {
    @Select("select * from user_info where user_name=#{name}")
    UserInfo queryUserInfoByName(String name);
}
