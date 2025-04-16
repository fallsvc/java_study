package com.fallsvc.principle.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/16  21:20
 */
@Component
public class BeanLifeComponent implements BeanNameAware {
    // DI 依赖注入分三种 属性、构造方法、setter 方法
    private Config config;


    public BeanLifeComponent() {
        System.out.println("构造方法");
    }
    @Autowired
    public void setConfig(Config config) {
        System.out.println("setter方法注入");
        this.config = config;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("通知BeanNameAware ："+name);
    }

    /**
     * 初始化方法 加注解就会自动执行
     */
    @PostConstruct
    public void init(){
        System.out.println("init方法初始化");
    }

    public void use(){
        System.out.println("Bean的使用");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁。。。。");
    }


}
