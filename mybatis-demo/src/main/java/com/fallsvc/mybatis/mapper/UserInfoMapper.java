package com.fallsvc.mybatis.mapper;

import com.fallsvc.mybatis.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/13  11:14
 */
@Mapper
public interface UserInfoMapper {
//    @Select("select * from user_info")
//    @Select("select id,username,password,age,gender,phone,"+
//            "delete_flag as deleteFlag,create_time as createTime," +
//            "update_time as updateTime from user_info;")
//    @Results(id="BaseMap",value = {
//            @Result(column = "delete_flag",property = "deleteFlag"),
//            @Result(column = "create_time",property = "createTime"),
//            @Result(column = "update_time",property = "updateTime")
//    })

    @Select("select * from user_info")
    List<UserInfo> selectAll();
//    @ResultMap(value = "BaseMap")
    @Select("select * from user_info where id= #{id}")
    UserInfo selectAllById(Integer id);
    @Select("select * from user_info where username=#{param1} and password=#{param2}")
    UserInfo selectAllBy(String username,String password);
    @Select("select * from user_info where username=#{userName} and password=#{password}")
    UserInfo selectAllBy2(@Param("userName") String username, String password);


    @Options(useGeneratedKeys = true,keyProperty = "id")// 获取自增id
    @Insert("insert into user_info (username,password,age) VALUES (#{username},#{password},#{age});")
    Integer insertUser(UserInfo userInfo);
    @Options(useGeneratedKeys = true,keyProperty = "id")// 获取自增id
    @Insert("insert into user_info (username,password,age) VALUES (#{userInfo.username},#{userInfo.password},#{userInfo.age});")
    Integer insertUser2(@Param("userInfo") UserInfo userInfo);


}
