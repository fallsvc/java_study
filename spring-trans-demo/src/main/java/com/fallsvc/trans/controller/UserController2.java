package com.fallsvc.trans.controller;


import com.fallsvc.trans.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RequestMapping("/user2")
@RestController
public class UserController2 {
    @Autowired
    private UserService userService;

    // @Transactional 异常时可能回滚（error ,RuntimeException） ,没有异常就进行提交
    // 如果异常进行捕获(处理异常了 )，事务会正常提交 （如果继续抛出的异常 可能会rollback ）
    // 只有修饰public方法才生效
    @Transactional
    @RequestMapping("/registry")
    public String registry(String name, String password) {
        //⽤⼾注册
        Integer result=userService.registryUser(name, password);
        log.info("用户注册成功,影响行数："+result);
        try {
            int a=10/0;
        } catch (Exception e) {
            log.info("算术异常");
            // 处理异常时如果不想抛出异常，又需要回滚，就需要手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return "注册成功";
    }
    // 此时事务没有进行回滚 只有抛出error or RuntimeException时才会回滚
    @Transactional
    @RequestMapping("/r2")
    public String r2(String name, String password) throws IOException {
        //⽤⼾注册
        Integer result=userService.registryUser(name, password);
        log.info("用户注册成功,影响行数："+result);
       if(true){
           throw new IOException();
       }
        return "注册成功";
    }

    /**
     * 事务进行回滚，rollbackFor 设置哪些异常时发生回滚
     * @param name
     * @param password
     * @return
     * @throws IOException
     */
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/r3")
    public String r3(String name, String password) throws IOException {
        //⽤⼾注册
        Integer result=userService.registryUser(name, password);
        log.info("用户注册成功,影响行数："+result);
       if(true){
           throw new IOException();
       }
        return "注册成功";
    }
}