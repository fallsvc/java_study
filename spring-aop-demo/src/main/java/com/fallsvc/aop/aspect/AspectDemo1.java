package com.fallsvc.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/26  11:04
 */

/**
 * @Order()执行优先级
 */
@Slf4j
@Aspect
@Order(1)
@Component
public class AspectDemo1 {
    @Pointcut("execution(* com.fallsvc.aop.controller.*.*(..))")
    public void pt(){};
    @Around("pt()")
    public Object recordTime(ProceedingJoinPoint pjp) {
        log.info("目标方法执行前....");
        Object proceed = null;
        try {
            proceed = pjp.proceed();
        } catch (Throwable e) {
            log.info("throwable .....");
        }
        log.info("目标方法执行后....");
        return proceed;
    }
    @After("pt()")
    public void after(){
        log.info("after ....");
    }
    @Before("pt()")
    public void before(){
        log.info("before ....");
    }
    @AfterReturning("pt()")
    public void afterReturning(){
        log.info("AfterReturning ....");
    }
    @AfterThrowing("pt()")
    public void afterThrowing(){
        log.info("AfterThrowing ....");
    }



}
