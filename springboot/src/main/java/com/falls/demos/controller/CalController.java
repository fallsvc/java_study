package com.falls.demos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/3  20:16
 */
@RequestMapping("/calc")
@RestController
public class CalController {
    @RequestMapping("/sum")
    public String sum(Integer num1,Integer num2){
        if(num1==null||num2==null){
            return "传参不合法";
        }
        Integer sum=num1+num2;
        return "<h1>计算结果为："+sum+"<h1>";
    }
    @RequestMapping("/sub")
    public String sub(Integer num1,Integer num2){
        if(num1==null||num2==null) return "传参不合法";

        return ""+num1+num2;
    }
}
