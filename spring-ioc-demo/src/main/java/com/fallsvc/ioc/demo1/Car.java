package com.fallsvc.ioc.demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/8  12:22
 */
public class Car {
    private Framework framework;

    public Car(Framework framework){
        this.framework=framework; // 注入DI

    }
}
