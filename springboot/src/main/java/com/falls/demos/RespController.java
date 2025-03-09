package com.falls.demos;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/2  9:44
 */

/**
 *@Target({ElementType.TYPE}) 什么注解 type类
 * @Retention(RetentionPolicy.RUNTIME) 生命周期
 * @Documented 文件
 *
 * @RestController =@Controller(扫描)+@ResponseBody(返回数据)
 */

@RequestMapping("/resp")
@Controller
public class RespController {
    /**
     * 返回页面
     * @return
     */
    @RequestMapping("r1")
    public String returnPage(){
        return "/index.html";
    }
    @ResponseBody // 返回数据
    @RequestMapping("r2")
    public String returnData(){
        return "ws";
    }

    @ResponseBody
    @RequestMapping("r3")
    public String returnHtml(){
        return "<h1>页面</h1>";
    }
    @ResponseBody
    @RequestMapping(value = "r4",produces = "text/plain")
    public String returnHtml2(){
        return "<h1>页面</h1>";
    }
    @ResponseBody
    @RequestMapping("r5")
    public UserInfo returnJson(){
        UserInfo userInfo=new UserInfo("zhangsan","11",19);
        return userInfo;
    }
    @ResponseBody
    @RequestMapping("r6")
    public UserInfo setStatus(HttpServletResponse response){
        response.setStatus(404);
        UserInfo userInfo=new UserInfo("zhangsan","11",19);
        return userInfo;
    }
    @ResponseBody
    @RequestMapping("r7")
    public String setHeader(HttpServletResponse response){
        response.setHeader("Header","Header");
        return "设置header成功"; 
    }
}
