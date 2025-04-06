package com.fallsvc.demo.service;

import com.fallsvc.demo.pojo.dataobject.BlogInfo;
import com.fallsvc.demo.pojo.request.AddBlogRequest;
import com.fallsvc.demo.pojo.response.BlogInfoResponse;

import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  22:33
 */
public interface BlogService {
    List<BlogInfoResponse> getList();

    BlogInfoResponse getBlogDetail(Integer blogId);

    BlogInfo getBlogInfoByBlogId(Integer blogId);

    Boolean addBlog(AddBlogRequest addBlogRequest);
}
