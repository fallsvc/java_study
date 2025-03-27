package com.fallsvc.log.facade;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/10  18:09
 */
public class Main {
    public static void main(String[] args) {
        FacadeClient facadeClient=new FacadeClient();
        facadeClient.on();
        facadeClient.off();
    }
}
