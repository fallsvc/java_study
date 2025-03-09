package com.fallsvc.ioc;

import com.fallsvc.ioc.component.UserComponent;
import com.fallsvc.ioc.config.UserConfig;
import com.fallsvc.ioc.controller.HController;
import com.fallsvc.ioc.controller.HelloController;
import com.fallsvc.ioc.model.Student;
import com.fallsvc.ioc.rep.UserRepository;
import com.fallsvc.ioc.service.UserService;
import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan("com.fallsvc.ioc")
@SpringBootApplication
public class SpringIocDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringIocDemoApplication.class, args);
		// 适合一个对象时
//		HelloController bean=context.getBean(HelloController.class);
//		bean.print();
//
//		HelloController bean2=(HelloController) context.getBean("helloController");
//		bean2.print();
//		HelloController bean3=context.getBean("helloController",HelloController.class);
//		bean3.print();

//		UserService userService=context.getBean(UserService.class);
//		userService.test();
//
//		UserRepository bean=context.getBean(UserRepository.class);
//		bean.test();
//
//		UserComponent bean2=context.getBean(UserComponent.class);
//		bean2.test();
//
//		UserConfig bean3=context.getBean(UserConfig.class);
//		bean3.test();
//
//		HController controller=(HController) context.getBean("HController");
//		controller.print();

//		Student bean1=(Student)context.getBean("s3");
//		System.out.println(bean1);
//		Student bean2=(Student)context.getBean("s4");
//		System.out.println(bean2);

//		HelloController helloController=context.getBean(HelloController.class);
//		helloController.print();

		UserService bean = context.getBean(UserService.class);
		bean.test();
	}

}
