package com.fallsvc.log.facade;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/10  17:24
 */
public class LivingRoomLight implements Light{
    @Override
    public void on() {
        System.out.println("打开客厅的灯");
    }

    @Override
    public void off() {
        System.out.println("关闭客厅的灯");
    }
}
