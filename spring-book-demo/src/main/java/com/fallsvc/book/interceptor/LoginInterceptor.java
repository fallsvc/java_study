package com.fallsvc.book.interceptor;

import com.fallsvc.book.constant.Constants;
import com.fallsvc.book.model.Result;
import com.fallsvc.book.model.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.StandardCharsets;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/22  10:18
 */

/**
 * 阻拦器
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle......");
        if(!login(request)){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(401);
            String msg="用户未登录";
            response.getOutputStream().write(msg.getBytes(StandardCharsets.UTF_8));
            log.warn(msg);
            return false;
        }

        log.info("用户已登录");
        return true;
    }
    public boolean login(HttpServletRequest request){
        HttpSession session=request.getSession();
        if(session==null||session.getAttribute(Constants.SESSION_USER_KEY)==null) return false;

        UserInfo userInfo=(UserInfo)session.getAttribute(Constants.SESSION_USER_KEY);
        if(userInfo==null||userInfo.getId()<0)  return false;


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterComletion");
    }


}
