package com.fallsvc.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/1  8:41
 */
public class DateUtils {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d=simpleDateFormat.format(date);
        System.out.println(d);
    }
}
