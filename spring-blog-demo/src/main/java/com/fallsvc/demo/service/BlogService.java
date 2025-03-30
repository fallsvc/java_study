package com.fallsvc.demo.service;

import com.fallsvc.demo.pojo.response.BlogInfoResponse;

import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/30  22:33
 */
public interface BlogService {
    List<BlogInfoResponse> getList();
}
