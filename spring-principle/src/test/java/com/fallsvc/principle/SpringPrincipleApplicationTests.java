package com.fallsvc.principle;

import com.fallsvc.principle.common.BeanLifeComponent;
import com.fallsvc.principle.model.Dog;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringPrincipleApplicationTests {
	@Autowired
	private ApplicationContext applicationContext;
	@Resource(name = "dog")
	private Dog dog1;
	@Test
	void contextLoads() {
		System.out.println(dog1);
		Dog dog2 = applicationContext.getBean(Dog.class);
		System.out.println(dog2);
		Dog dog3 = applicationContext.getBean(Dog.class);
		System.out.println(dog3);
	}
	@Test
	void dogTest(){
		Dog dog=new Dog();
		Dog dog2=new Dog();
		dog.setAge(1);
		dog2.setAge(1);
		System.out.println(dog.equals(dog2));
		System.out.println(dog==dog2);
	}

	@Test
	void beanLifeComponentTest(){
		BeanLifeComponent beanLifeComponent=applicationContext.getBean(BeanLifeComponent.class);
		beanLifeComponent.use();
	}

}
