package com.fallsvc.ioc.demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/8  12:31
 */
public class Bottom {
    private Tire tire;
    public Bottom(Tire tire){
        this.tire=tire; // 注入 DI
    }
}
