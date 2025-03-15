package com.fallsvc.mybatis.commomtest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/13  20:00
 */
public class Demo {
    @Test
    void t1(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(x-> System.out.println(x));
        System.out.println(list.stream().filter(x -> x == 1));
    }
}
