package com.falls.demos.controller;

import com.falls.demos.model.UserInfo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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
     * @RequestParam 默认必传参数不会null
     * 可以重命名参数
     * require参数默认为true 必传参数 只能以重命名传参
     * 如果require设为false则就不为必传参数
     * @param keyword - q
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
    //这里参数绑定list为必传参数
    public String r6(@RequestParam List<Integer> list){
        return list.toString();
    }

    @RequestMapping("/r7")
    public String r7(@RequestBody UserInfo userInfo){
        System.out.println(userInfo);
        return userInfo.toString();
    }

    @RequestMapping("/r8/{type}/{article}")
    public String r8(@PathVariable Integer article,@PathVariable("type") String thetype){
        return "articleID"+article+",type:"+thetype;
    }

    /**
     * RequestPart 重命名
     * @param file1
     * @return
     * @throws IOException
     */
    @RequestMapping("/r9")
    public String r9(@RequestPart("file")MultipartFile file1) throws IOException {
        System.out.println(file1.getOriginalFilename());
        // 文件上传
        file1.transferTo(new File("C:\\Users\\12092\\Desktop\\software\\"+file1.getOriginalFilename()));

        return "文件上传成功";
    }
    @RequestMapping("/r10")
    public String r10(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies= request.getCookies();
        if(cookies!=null){
            for (Cookie cookie: cookies) {
                System.out.println(cookie.getName()+":"+cookie.getValue());
            }
        }
        return "返回Cookie成功";
    }
    @RequestMapping("/r11")
    public String r11(@CookieValue("java")String java){
        System.out.println(java);
        return "Cookie中java的值="+java;
    }
    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request){
        // 从cookie中获取sessionId,根据sessionId获得session对象
        HttpSession session=request.getSession();
        //默认存储在储存中
        session.setAttribute("name","zhangsan");
        session.setAttribute("age",12);

        return "设置成功";
    }
    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request){
        // 从cookie中获取sessionId,根据sessionId获得session对象
        HttpSession session=request.getSession();
        // 如果用户登录有值，否则session为null
        if(session==null){
            return "用户未登录";
        }else{
            String userName=(String)session.getAttribute("name");
            return "用户名"+userName;
        }
    }
    @RequestMapping("/getSession2")
    public String getSession2(HttpSession session){
        // 如果用户登录有值，否则session为null
        if(session==null){
            return "用户未登录";
        }else{
            String userName=(String)session.getAttribute("name");
            return "用户名"+userName;
        }
    }
     @RequestMapping("/getSession3")
    public String getSession3(@SessionAttribute("name") String userName){
            return "用户名"+userName;
    }

    @RequestMapping("/getHeader")
    public String getHeader(HttpServletRequest request){
        String userAgent=request.getHeader("User-Agent");
        return "header中的useragent"+userAgent;
    }
    @RequestMapping("/getHeader2")
    public String getHeader2(@RequestHeader("User-Agent") String userAgent){
        return "header中的useragent"+userAgent;
    }
}

