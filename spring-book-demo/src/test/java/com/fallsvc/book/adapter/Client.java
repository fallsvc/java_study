package com.fallsvc.book.adapter;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/24  11:10
 */
public class Client {
    public static void main1(String[] args) {
        Slf4jApi slf4jApi=new Log4jSlf4jAdapter(new Log4j());
        slf4jApi.log("stringskjafk");

        Slf4jApi slf4jApi1=new LogbackSlf4jAdapter(new Logback());
        slf4jApi1.log("qwwweyuyu");
    }

//    public static void main(String[] args) {
//        DispatcherServlet
//    }
}
