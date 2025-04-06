package com.fallsvc.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fallsvc.demo.common.exception.BlogException;
import com.fallsvc.demo.common.utils.BeanTransUtils;
import com.fallsvc.demo.mapper.BlogInfoMapper;
import com.fallsvc.demo.pojo.dataobject.BlogInfo;
import com.fallsvc.demo.pojo.request.AddBlogRequest;
import com.fallsvc.demo.pojo.response.BlogInfoResponse;
import com.fallsvc.demo.service.BlogService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  22:28
 */
@Slf4j
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
                .map(blogInfo -> BeanTransUtils.trans(blogInfo))
                .collect(Collectors.toList());

        return blogInfoResponses;
    }

    @Override
    public BlogInfoResponse getBlogDetail(Integer blogId) {
        BlogInfo blogInfo=getBlogInfoByBlogId(blogId);
        //

        return BeanTransUtils.trans(blogInfo);
    }
    @Override

    public BlogInfo getBlogInfoByBlogId(Integer blogId){
        QueryWrapper<BlogInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag,0)
                .eq(BlogInfo::getId,blogId);
        BlogInfo blogInfo=blogInfoMapper.selectOne(queryWrapper);
        return blogInfo;
    }

    @Override
    public Boolean addBlog(AddBlogRequest addBlogRequest) {
        BlogInfo blogInfo=new BlogInfo();
        BeanUtils.copyProperties(addBlogRequest,blogInfo);
        try{
            Integer result=blogInfoMapper.insert(blogInfo);
            if(result==1) return true;
            return false;
        }catch (Exception e){
            log.info("博客发布失败，插入失败");
            throw new BlogException("内部错误");
        }
    }
}
