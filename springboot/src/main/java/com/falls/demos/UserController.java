package com.falls.demos;

import org.springframework.web.bind.annotation.*;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/24  15:36
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/m1")
    public String m1(){
        return "user";
    }
//   //  只支持get
    @RequestMapping(value = "/m2",method = RequestMethod.GET)
    public String m2(){
        return "m2";
    }

    // 只支持post
    @RequestMapping(value = "/m3",method = RequestMethod.POST)
    public String m3(){
        return "m3";
    }

    @GetMapping("/m4")
    public String m4(){
        return "m4";
    }
    @PostMapping("/m5")
    public String m5(){
        return "m5";
    }

    @RequestMapping(value = "m6",method = {RequestMethod.GET,RequestMethod.POST})
    public String m6(){
        return "m6";
    }
}
