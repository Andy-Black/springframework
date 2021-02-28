package com.imooc.controller;

import com.imooc.service.WelcomeService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

@Controller
public class WelcomeController implements ApplicationContextAware, BeanNameAware {

	private String myName;
	private ApplicationContext applicationContext;
	@Autowired
	private WelcomeService welcomeService;

	public void handleRequest(){
		welcomeService.sayHello("来自Controller的问候");
		System.out.println("我是谁" + myName);
	}
	@Override
	public void setBeanName(String name) {

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

	}
}
