package com.fallsvc.log.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/10  17:04
 */
@Slf4j
@RequestMapping("/log2")
@RestController
public class LogController2 {
    @RequestMapping("/print")
    public String print(){
        System.out.println("打印日志");
        log.info("logger打印");
        log.error("error");
        log.trace("trace");
        log.debug("debug");
        log.warn("warn");

        return "dayin";
    }
}
