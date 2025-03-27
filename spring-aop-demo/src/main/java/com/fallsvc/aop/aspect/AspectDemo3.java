package com.fallsvc.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/26  16:05
 */
@Slf4j
@Aspect
@Order(2)
@Component
public class AspectDemo3 {
    @Before("com.fallsvc.aop.aspect.AspectDemo1.pt()")
    public void before(){
        log.info("aspectDemo3 before....");
    }
    @After("com.fallsvc.aop.aspect.AspectDemo1.pt()")
    public void after(){
        log.info("aspectdemo3 after....");
    }
}
