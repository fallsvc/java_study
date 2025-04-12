package com.fallsvc.demo.common.utils;

import com.fallsvc.demo.pojo.dataobject.BlogInfo;
import com.fallsvc.demo.pojo.dataobject.UserInfo;
import com.fallsvc.demo.pojo.request.UpdateBlogRequest;
import com.fallsvc.demo.pojo.response.BlogInfoResponse;
import com.fallsvc.demo.pojo.response.UserInfoResponse;
import org.springframework.beans.BeanUtils;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/1  9:32
 */
public class BeanTransUtils {
    public static BlogInfoResponse trans(BlogInfo blogInfo){
        if(blogInfo==null){
            return null;
        }
        //TODO
        BlogInfoResponse blogInfoResponse=new BlogInfoResponse();
        BeanUtils.copyProperties(blogInfo,blogInfoResponse); // blogInfo->blogInfoResponse
        return blogInfoResponse;
    }
    public static UserInfoResponse trans(UserInfo userInfo){
        if(userInfo==null) return null;
        //TODO
        UserInfoResponse userInfoResponse=new UserInfoResponse();
        BeanUtils.copyProperties(userInfo,userInfoResponse); // userInfo->userInfoResponse
        return userInfoResponse;
    }

    public static BlogInfo trans(UpdateBlogRequest updateBlogRequest){
        if(updateBlogRequest==null) return null;

        BlogInfo blogInfo=new BlogInfo();
        BeanUtils.copyProperties(updateBlogRequest,blogInfo);
        return blogInfo;
    }
}
