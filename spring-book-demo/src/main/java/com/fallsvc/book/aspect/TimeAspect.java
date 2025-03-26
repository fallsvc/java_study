package com.fallsvc.book.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/25  10:35
 */
@Slf4j
@Aspect
@Component
public class TimeAspect {
    @Around("execution(* com.fallsvc.book.*.*.*(..))")
    public Object timeRecord(ProceedingJoinPoint pjp) throws Throwable {
        long start=System.currentTimeMillis();
        Object proceed = pjp.proceed();// 目标方法执行
        long end=System.currentTimeMillis();

        log.info(pjp.getSignature()+"耗时："+(end-start)+"ms");
        return proceed;
    }
}
