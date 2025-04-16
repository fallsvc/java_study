package com.fallsvc.principle.common;

import com.fallsvc.principle.model.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/16  19:39
 */
@Component
public class Config {
    /**
     * 生成一个对象让spring ioc 管理
     * @return
     */
    @Bean
    public Dog dog(){
        return new Dog();
    }
    @Bean("dogSingleton")
    public Dog dogSingleton(){
        return new Dog();
    }
    @Bean
    @Scope("prototype")
    public Dog dogPrototype(){
        return new Dog();
    }
    @Bean
    @RequestScope
    public Dog dogRequest(){
        return new Dog();
    }
    @Bean
    @SessionScope
    public Dog dogSession(){
        return new Dog();
    }
    @Bean
    @ApplicationScope
    public Dog dogApplication(){
        return new Dog();
    }
}
