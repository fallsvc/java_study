package com.falls.demos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/24  16:43
 */

@RequestMapping("/request")
@RestController
public class RequestController {
    @RequestMapping("/r1")
    public String r1(String r){
        return "接受参数+ "+r;
    }
    @RequestMapping("/r2")
    public String r2(String userName,String password){
        return "用户名： "+userName+"\n密码："+password;
    }

    @RequestMapping("/r3")
    public String r3(UserInfo userInfo){
        return userInfo.toString();
    }

    /**
     * requestParam 默认必传参数不会null
     * @param keyword
     * @return
     */
    @RequestMapping("/r4")
    public String r4(@RequestParam(value = "q",required = false) String keyword){
        return "r4 q"+keyword;
    }

    @RequestMapping("/r5")
    public String r5(int[] arr){
        return Arrays.toString(arr);
    }

    @RequestMapping("/r6")
    public String r6(@RequestParam List<Integer> list){
        return list.toString();
    }
}
