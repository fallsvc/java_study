package com.fallsvc.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.fallsvc.mybatisplus.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.yaml.snakeyaml.scanner.Constant;


import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/20  21:26
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    @Select("select * from user_info where id=#{id}")
    UserInfo selectById2(Integer id);

    @Select("select id,user_name from user_info")
    List<UserInfo> selectUserInfoByCondition(@Param(Constants.WRAPPER) Wrapper<UserInfo> w);
    @Select("select id,user_name from user_info ${ew.customSqlSegment}")
    List<UserInfo> selectUserInfoByCondition2(Wrapper<UserInfo> ew);

    List<UserInfo> selectAll();
}
