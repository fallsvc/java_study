package com.falls.demos;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @RequestMapping("/r7")
    public String r7(@RequestBody UserInfo userInfo){
        System.out.println(userInfo);
        return userInfo.toString();
    }

    @RequestMapping("/r8/{type}/{article}")
    public String r8(@PathVariable Integer article,@PathVariable String type){
        return "articleID"+article+",type:"+type;
    }

    @RequestMapping("/r9")
    public String r9(@RequestPart("file")MultipartFile file1) throws IOException {
        System.out.println(file1.getOriginalFilename());
        // 文件上传
        file1.transferTo(new File("C:\\Users\\12092\\Desktop\\software\\"+file1.getOriginalFilename()));

        return "文件上传成功";
    }
}

