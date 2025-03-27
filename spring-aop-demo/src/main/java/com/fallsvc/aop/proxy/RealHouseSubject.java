package com.fallsvc.aop.proxy;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/26  21:04
 */
public class RealHouseSubject implements HouseSubject{
    @Override
    public void rentHouse() {
        System.out.println("卖家出租房子");
    }

    @Override
    public void saleHouse() {
        System.out.println("卖家卖房子");
    }
}
