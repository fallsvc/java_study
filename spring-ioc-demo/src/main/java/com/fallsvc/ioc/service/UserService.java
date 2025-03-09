package com.fallsvc.ioc.service;

import com.fallsvc.ioc.model.Student;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/8  20:54
 */
@Service
public class UserService {
//    @Qualifier("s2") //指定s2对象
//    @Autowired
//    private Student s1;

    /**
     * @Resource JDK提供
     */
    @Resource(name = "s3")
    private Student s1;
    public void test(){
        System.out.println("do. service");
        System.out.println(s1);
    }
}
