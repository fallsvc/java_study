package com.fallsvc.aop.proxy;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/26  21:03
 */
public class HouseProxy implements HouseSubject{
    private RealHouseSubject realHouseSubject;

    public HouseProxy(RealHouseSubject realHouseSubject) {
        this.realHouseSubject = realHouseSubject;
    }

    @Override
    public void rentHouse() {
        System.out.println("代理开始代理");
        realHouseSubject.rentHouse();
        System.out.println("代理结束代理");
    }

    @Override
    public void saleHouse() {
        System.out.println("代理开始代理");
        realHouseSubject.saleHouse();
        System.out.println("代理结束代理");
    }
}
