package com.fallsvc.principle.controller;

import com.fallsvc.principle.model.Dog;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/16  20:03
 */

/**
 * 6个Bean 的作用域
 */
@RestController
@RequestMapping("/dog")
public class DogController {
    @Autowired
    private ApplicationContext context;
    @Resource(name = "dogSingleton")
    private Dog dog;
    @Resource(name = "dogPrototype") // 注入时拿一个不会变
    private Dog dogPrototype;
    @Resource(name = "dogRequest") // 注入同一个请求的
    private Dog dogRequest;
    @Resource(name = "dogSession") // 注入同一个会话的
    private Dog dogSession;
    @Resource(name = "dogApplication") // 注入同一个程序的
    private Dog dogApplication;

    @RequestMapping("/singleton")
    public String singleton(){
        Dog dog1=context.getBean("dogSingleton",Dog.class);
        return dog+"         "+dog1;// 单例，怎么注入都是同一个对象
    }

    @RequestMapping("/prototype")
    public String prototype(){
        Dog dog1=context.getBean("dogPrototype",Dog.class);// 每次生成一个新对象 注入的保持不变

        return dogPrototype+"         "+dog1;
    }
    @RequestMapping("/request")
    public String request(){
        Dog dog1=context.getBean("dogRequest",Dog.class);// 每次请求生成一个新对象 和注入相同

        return dogRequest+"         "+dog1;
    }
    @RequestMapping("/session")
    public String session(){
        Dog dog1=context.getBean("dogSession",Dog.class);// 每次session会话生成一个新对象 和注入相同

        return dogSession+"         "+dog1;
    }
    @RequestMapping("/application")
    public String application(){
        Dog dog1=context.getBean("dogApplication",Dog.class);// 程序生成一个新对象 和注入相同

        return dogApplication+"         "+dog1;
    }
    // 第6个作用域区别 websocket

}
