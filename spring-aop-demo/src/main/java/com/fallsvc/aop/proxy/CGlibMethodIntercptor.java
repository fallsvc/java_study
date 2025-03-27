package com.fallsvc.aop.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/27  21:17
 */
public class CGlibMethodIntercptor implements MethodInterceptor {
    private Object target;

    public CGlibMethodIntercptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我开始代理");
        Object invoke = method.invoke(target, objects);
        System.out.println("我结束代理");
        return invoke;
    }
}
