package com.fallsvc.demo.common.utils;

import com.fallsvc.demo.pojo.dataobject.BlogInfo;
import com.fallsvc.demo.pojo.response.BlogInfoResponse;
import org.springframework.beans.BeanUtils;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/1  9:32
 */
public class BeanParseUtils{
    public static BlogInfoResponse trans(BlogInfo blogInfo){
        //TODO
        BlogInfoResponse blogInfoResponse=new BlogInfoResponse();
        BeanUtils.copyProperties(blogInfo,blogInfoResponse); // blogInfo->blogInfoResponse
        return blogInfoResponse;
    }
}
