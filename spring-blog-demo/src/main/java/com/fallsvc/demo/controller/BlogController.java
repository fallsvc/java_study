package com.fallsvc.demo.controller;

import com.fallsvc.demo.pojo.request.AddBlogRequest;
import com.fallsvc.demo.pojo.request.UpdateBlogRequest;
import com.fallsvc.demo.pojo.response.BlogInfoResponse;
import com.fallsvc.demo.service.BlogService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  22:27
 */
@Slf4j
@RequestMapping("/blog")
@RestController
public class BlogController {


    @Resource(name="blogServiceImpl")
    private BlogService blogService;

    @RequestMapping("/getList")
    public List<BlogInfoResponse> getList(){
        log.info("获得图书");
        return blogService.getList();
    }

    @RequestMapping("/getBlogDetail")
    public BlogInfoResponse getBlogDetail(@NotNull(message = "blogId不能为null") Integer blogId){
        log.info("获取博客信息，blogId：{}",blogId);
        return blogService.getBlogDetail(blogId);
    }
    /**
     * 添加博客
     */
    @RequestMapping("/add")
    public Boolean addBlog(@RequestBody @Validated AddBlogRequest addBlogRequest){
        log.info("添加博客信息，用户id：{}，博客标题：{}",addBlogRequest.getUserId(),addBlogRequest.getTitle());
        return blogService.addBlog(addBlogRequest);
    }

    @RequestMapping("/update")
    public Boolean updateBlog(@RequestBody @Validated UpdateBlogRequest updateBlogRequest){
        log.info("更新博客：{}",updateBlogRequest);
        return blogService.updateBlog(updateBlogRequest);
    }
    @RequestMapping("/delete")
    public Boolean deleteBlog(@NotNull(message = "id不能为空") Integer blogId){
        log.info("删除图书id："+blogId);
        return blogService.deleteBlog(blogId);
    }
}
