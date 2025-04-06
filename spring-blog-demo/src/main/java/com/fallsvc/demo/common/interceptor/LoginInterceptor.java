package com.fallsvc.demo.common.interceptor;

import com.fallsvc.demo.common.constant.Constants;
import com.fallsvc.demo.common.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/6  14:11
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader(Constants.USER_TOKEN_HEADER_KEY);
        log.info("从Header里面拿到token："+token);

        if(token==null){
            response.setStatus(401);
            return false;
        }
        // token 是否合法
        Claims claims= JwtUtils.parseToken(token);
        if(claims==null){
            response.setStatus(401);
            return false;
        }

        return true;
    }
}
