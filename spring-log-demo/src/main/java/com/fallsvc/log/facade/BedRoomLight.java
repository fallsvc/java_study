package com.fallsvc.log.facade;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/10  17:24
 */
public class BedRoomLight implements Light{

    @Override
    public void on() {
        System.out.println("打开卧室的灯");
    }

    @Override
    public void off() {
        System.out.println("关闭卧室的灯");
    }
}
