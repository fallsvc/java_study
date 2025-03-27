package com.fallsvc.aop.proxy;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/26  21:07
 */
public class Main {
    public static void main(String[] args) {
        RealHouseSubject realHouseSubject=new RealHouseSubject();
        HouseProxy houseProxy=new HouseProxy(realHouseSubject);

        houseProxy.rentHouse();
        houseProxy.saleHouse();
    }
}
