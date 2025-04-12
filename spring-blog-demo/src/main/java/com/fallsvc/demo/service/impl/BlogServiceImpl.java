package com.fallsvc.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fallsvc.demo.common.constant.Constants;
import com.fallsvc.demo.common.exception.BlogException;
import com.fallsvc.demo.common.utils.BeanTransUtils;
import com.fallsvc.demo.mapper.BlogInfoMapper;
import com.fallsvc.demo.pojo.dataobject.BlogInfo;
import com.fallsvc.demo.pojo.dataobject.UserInfo;
import com.fallsvc.demo.pojo.request.AddBlogRequest;
import com.fallsvc.demo.pojo.request.UpdateBlogRequest;
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
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag,Constants.BLOG_NORMAL);
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
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag,Constants.BLOG_NORMAL)
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

    @Override
    public Boolean updateBlog(UpdateBlogRequest updateBlogRequest) {
        BlogInfo blogInfo=BeanTransUtils.trans(updateBlogRequest);

        try {
            int ret=blogInfoMapper.updateById(blogInfo);
            return ret==1;
        } catch (Exception e) {
            log.info("更新博客失败e:{}",e);
            throw new BlogException("内部错误");
        }
    }

    @Override
    public Boolean deleteBlog(Integer id) {
        BlogInfo blogInfo=new BlogInfo();
        blogInfo.setId(id);
        blogInfo.setDeleteFlag(Constants.BLOG_DELETE);
        try {
            int ret=blogInfoMapper.updateById(blogInfo);
            return ret==1;
        } catch (Exception e) {
            log.info("删除博客失败e:{}",e);
            throw new BlogException("内部错误");
        }
    }
}
