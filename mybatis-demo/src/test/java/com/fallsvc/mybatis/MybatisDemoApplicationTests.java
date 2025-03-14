package com.fallsvc.mybatis;

import com.fallsvc.mybatis.mapper.UserInfoMapper;
import com.fallsvc.mybatis.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class MybatisDemoApplicationTests {
	@Autowired
	private ApplicationContext context;
	@Test
	void contextLoads() {
		UserInfoMapper bean=context.getBean(UserInfoMapper.class);
		bean.selectAll().stream().forEach(x-> System.out.println(x));
	}

}
