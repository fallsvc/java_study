package com.fallsvc.aop.proxy;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/26  21:07
 */
public class Main {
    public static void main(String[] args) {
        RealHouseSubject realHouseSubject=new RealHouseSubject();
//        HouseProxy houseProxy=new HouseProxy(realHouseSubject);
//
//        houseProxy.rentHouse();
//        houseProxy.saleHouse();

//        HouseSubject houseSubjectProxy= (HouseSubject) Proxy.newProxyInstance(realHouseSubject.getClass().getClassLoader(),
//                new Class[]{HouseSubject.class},new JDKInvocation(realHouseSubject));
//        houseSubjectProxy.rentHouse();

        HouseSubject houseProxy=(HouseSubject) Enhancer.create(realHouseSubject.getClass(),new CGlibMethodIntercptor(realHouseSubject));
        houseProxy.rentHouse();
    }
}
