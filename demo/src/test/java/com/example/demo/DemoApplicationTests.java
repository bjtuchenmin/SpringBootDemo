package com.example.demo;

import com.example.demo.beanConfig.TestAnnotationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void testBeanConfig() {
		// xml 配置容器
		ClassPathXmlApplicationContext xmlContext
				= new ClassPathXmlApplicationContext("user-bean-config.xml");
		Object beanConfiguredByJava = xmlContext.getBean("beanConfiguredByJava");


		// 注解配置容器
		AnnotationConfigApplicationContext annotationContext
				= new AnnotationConfigApplicationContext(TestAnnotationConfig.class);
		TestAnnotationConfig bean = annotationContext.getBean(TestAnnotationConfig.class);

		ClassPathXmlApplicationContext context2
				= new ClassPathXmlApplicationContext("customBean.xml");
		Object beanConfiguredByXML = context2.getBean("beanConfiguredByXML");
		System.out.println(1);
	}
}
