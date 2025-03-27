package com.fallsvc.ioc.demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/8  12:20
 */
public class Main {
    public static void main(String[] args) {
        Tire tire=new Tire(12);
        Bottom bottom=new Bottom(tire);
        Framework framework=new Framework(bottom);
        Car car=new Car(framework);

    }
}
