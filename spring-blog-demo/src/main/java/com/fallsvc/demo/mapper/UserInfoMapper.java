package com.fallsvc.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fallsvc.demo.pojo.dataobject.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  22:24
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
