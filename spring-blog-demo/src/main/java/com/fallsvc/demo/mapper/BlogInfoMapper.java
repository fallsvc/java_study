package com.fallsvc.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fallsvc.demo.pojo.dataobject.BlogInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  22:25
 */
@Mapper
public interface BlogInfoMapper extends BaseMapper<BlogInfo> {
}
