package com.fallsvc.principle;

import com.fallsvc.config.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

// 扫描这个路径的类让ioc管理
// 1.
//@ComponentScan(basePackages = "com.fallsvc.config")
// 2.
//@Import(Config.class) // 一个类 or
//@Import({Config.class, Config2.class})
// 3. 统计在一个
//@Import(MySelector.class)



// 4. 注解
//@EnableConfigs
@Import(MyRegistrar.class)

@SpringBootApplication
public class SpringPrincipleApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SpringPrincipleApplication.class, args);
		Config bean = context.getBean("config1",Config.class);
		bean.config();
//		Config2 bean2=context.getBean(Config2.class);
//		bean2.config();
//		Config bean2=context.getBean(Config.class);
//		System.out.println(bean2==bean);
	}

}
