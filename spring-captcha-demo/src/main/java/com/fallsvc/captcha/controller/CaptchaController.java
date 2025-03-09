package com.fallsvc.captcha.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.fallsvc.captcha.model.CaptchaProperties;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/9  20:44
 */
@RequestMapping("/captcha")
@RestController
public class CaptchaController {
    private static final long VALID_TIME =60*1000 ;
    @Autowired
    private CaptchaProperties captchaProperties;
    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpSession session, HttpServletResponse response)  {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(captchaProperties.getWidth(), captchaProperties.getHeight());

        //图形验证码写出，可以写出到文件，也可以写出到流
        try {
            String code=lineCaptcha.getCode();
            session.setAttribute(captchaProperties.getSession().getKey(),code);
            session.setAttribute(captchaProperties.getSession().getDate(),new Date());
            lineCaptcha.write(response.getOutputStream());
       ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @RequestMapping("/check")
    public boolean check(String captcha,HttpSession session){
       if(!StringUtils.hasLength(captcha)){
           return false;
       }

        String code=(String) session.getAttribute(captchaProperties.getSession().getKey());
        Date date=(Date)session.getAttribute(captchaProperties.getSession().getDate());
        if(captcha.equals(code)&&System.currentTimeMillis()-date.getTime()<VALID_TIME){
            return true;
        }
        return false;
    }
}
