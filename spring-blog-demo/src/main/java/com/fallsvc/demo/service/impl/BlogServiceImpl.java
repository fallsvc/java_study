package com.fallsvc.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fallsvc.demo.common.utils.BeanParseUtils;
import com.fallsvc.demo.mapper.BlogInfoMapper;
import com.fallsvc.demo.pojo.dataobject.BlogInfo;
import com.fallsvc.demo.pojo.response.BlogInfoResponse;
import com.fallsvc.demo.service.BlogService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  22:28
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Resource(name="blogInfoMapper")
    private BlogInfoMapper blogInfoMapper;
    @Override
    public List<BlogInfoResponse> getList() {
        QueryWrapper<BlogInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag,0);
        List<BlogInfo> blogInfos=blogInfoMapper.selectList(queryWrapper);
        // 业务层处理
        List<BlogInfoResponse> blogInfoResponses = blogInfos.stream()
                .map(blogInfo -> BeanParseUtils.trans(blogInfo))
                .collect(Collectors.toList());

        return blogInfoResponses;
    }

    @Override
    public BlogInfoResponse getBlogDetail(Integer blogId) {
        QueryWrapper<BlogInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag,0)
                .eq(BlogInfo::getId,blogId);
        BlogInfo blogInfo=blogInfoMapper.selectOne(queryWrapper);

        //
        BlogInfoResponse blogInfoResponse=BeanParseUtils.trans(blogInfo);

        return blogInfoResponse;
    }
}
