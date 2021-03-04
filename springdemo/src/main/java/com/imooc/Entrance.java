package com.imooc;

import com.imooc.controller.HelloController;
import com.imooc.controller.HiController;
import com.imooc.entity.User;
import com.imooc.entity.factory.UserFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.imooc")
public class Entrance {
	public static void main1(String[] args) {
		System.out.println("Hello World!");
		String xmlPath = "E:\\ideaworkspace\\spring-framework-5.2.9.RELEASE\\springdemo\\src\\main\\resources\\spring\\spring-config.xml";
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(xmlPath);

		//得到无参构造函数创建的对象
		User user1a = (User) applicationContext.getBean("user1");
		User user1b = (User) applicationContext.getBean("user1");
		//得到静态工厂创建的对象
		User user2a = (User) applicationContext.getBean("user2");
		User user2b = (User) applicationContext.getBean("user2");
		//得到实例工厂创建的对象
		User user3a = (User) applicationContext.getBean("user3");
		User user3b = (User) applicationContext.getBean("user3");
		//得到实例工厂创建的对象
		UserFactoryBean userFactoryBeana = (UserFactoryBean) applicationContext.getBean("userFactoryBean");
		UserFactoryBean userFactoryBeanb = (UserFactoryBean) applicationContext.getBean("userFactoryBean");

		System.out.println("无参构造函数创建的对象" + user1a);
		System.out.println("无参构造函数创建的对象" + user1b);
		System.out.println("静态工厂创建的对象" + user2a);
		System.out.println("静态工厂创建的对象" + user2b);
		System.out.println("实例工厂创建的对象" + user3a);
		System.out.println("实例工厂创建的对象" + user3b);
		System.out.println("factoryBean创建的对象" + userFactoryBeana);
		System.out.println("factoryBean创建的对象" + userFactoryBeanb);
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Entrance.class);
		System.out.println("==================轮到AOP登场啦=================");
		HelloController helloController = (HelloController) applicationContext.getBean("helloController");
		helloController.handleRequest();
		HiController hiController = (HiController) applicationContext.getBean("hiController");
		hiController.handleRequest();
//		Company company = (Company) applicationContext.getBean("company");
// 		User user = (User) applicationContext.getBean("user5");
//		System.out.println("CustomizedBeanDefinitionRegistryPostProcessor创建的对象" + user);
	}
}