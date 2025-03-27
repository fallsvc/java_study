package com.fallsvc.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/27  20:22
 */
public class JDKInvocation implements InvocationHandler {
    private Object target;

    public JDKInvocation(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始代理");
        Object invoke=method.invoke(target,args);
        System.out.println("结束代理");
        return invoke;
    }
}
