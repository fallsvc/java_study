package com.fallsvc.log.facade;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/10  18:01
 */
public class HallLight implements Light{
    @Override
    public void on() {
        System.out.println("走廊灯开");
    }

    @Override
    public void off() {
        System.out.println("走廊关灯");
    }
}
