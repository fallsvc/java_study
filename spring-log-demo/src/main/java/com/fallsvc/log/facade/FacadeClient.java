package com.fallsvc.log.facade;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/10  18:03
 */
public class FacadeClient {
    private LivingRoomLight livingRoomLight=new LivingRoomLight();
    private BedRoomLight bedRoomLight=new BedRoomLight();
    private HallLight hallLight=new HallLight();
    public void on(){
        livingRoomLight.on();
        bedRoomLight.on();
        hallLight.on();
    }
    public void off(){
        livingRoomLight.off();
        bedRoomLight.off();
        hallLight.off();
    }
}
