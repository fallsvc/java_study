package com.fallsvc.aop.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/26  19:48
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice{
    @ExceptionHandler
    public void t1(Exception e){

    }
    @ExceptionHandler(RuntimeException.class)
    public void t2(Exception e){

    }
}
