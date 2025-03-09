package com.fallsvc.ioc.component;

import com.fallsvc.ioc.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/8  21:36
 */
@Component
public class StudentComponent {
    // 同一个名字
    @Bean({"s3","s4"})
//    @Bean(name={"s3","s4"})
////    @Bean(value{"s3","s4"})
    public Student s1(){
        return new Student("zhangsan",19);
    }

//    @Primary 指定为主要的，Autowired拿到
    @Bean("s2")
    public Student s2(){
        return new Student("lisi",20);
    }

    @Bean
    public Student s(@Qualifier("s2") Student student){
        return student;
    }

}
