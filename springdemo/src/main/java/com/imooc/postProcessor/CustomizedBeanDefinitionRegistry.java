package com.imooc.postProcessor;

import com.imooc.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomizedBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		Class<User> userClass = User.class;
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(userClass);
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getRawBeanDefinition();
		registry.registerBeanDefinition("user5", beanDefinition);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
}
