package com.fallsvc.log.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.processing.Generated;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/10  17:04
 */
@RequestMapping("/log")
@RestController
public class LogController {
    private static Logger logger= LoggerFactory.getLogger(LogController.class);
    @RequestMapping("/print")
    public String print(){
        System.out.println("打印日志");
        logger.info("logger打印");
        logger.error("error");
        logger.trace("trace");
        logger.debug("debug");
        logger.warn("warn");

        return "dayin";
    }
}
