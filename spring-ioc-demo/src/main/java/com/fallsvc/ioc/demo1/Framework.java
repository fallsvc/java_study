package com.fallsvc.ioc.demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/8  12:31
 */
public class Framework {
    private Bottom bottom;
    public Framework(Bottom bottom){
        this.bottom=bottom; // 注入DI
    }
}
