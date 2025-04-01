package com.fallsvc.demo.controller;

import com.fallsvc.demo.pojo.response.BlogInfoResponse;
import com.fallsvc.demo.service.BlogService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
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
    public BlogInfoResponse getBlogDetail(@NotNull Integer blogId){
        log.info("获取博客信息，blogId：{}",blogId);
        return blogService.getBlogDetail(blogId);
    }

}
