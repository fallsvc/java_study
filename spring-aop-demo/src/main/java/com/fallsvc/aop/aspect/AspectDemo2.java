package com.fallsvc.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
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
@Order(3)
@Component
public class AspectDemo2 {
    // 加此注解的生效该方法
    @Around("@annotation(com.fallsvc.aop.aspect.MyAspect)")
    public Object recordTime(ProceedingJoinPoint pjp) {
        log.info("目标方法执行前2....");
        Object proceed = null;
        try {
            proceed = pjp.proceed();
        } catch (Throwable e) {
            log.info("throwable .....");
        }

        log.info("目标方法执行后2....");
        return proceed;
    }
    @Before("com.fallsvc.aop.aspect.AspectDemo1.pt()")
    public void before(){
        log.info("aspectDemo2 before....");
    }
    @After("com.fallsvc.aop.aspect.AspectDemo1.pt()")
    public void after(){
        log.info("aspectdemo2 after....");
    }
}
