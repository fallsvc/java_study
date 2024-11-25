package com.falls.demos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/24  13:47
 */

@RequestMapping("/hellos")
@RestController
public class HelloController {
    @RequestMapping("/hello/v1")
    public String hello(){
        return "hello ,Spring boot~";
    }
}
