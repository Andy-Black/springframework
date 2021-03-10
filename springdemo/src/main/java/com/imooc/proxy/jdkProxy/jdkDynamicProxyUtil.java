package com.imooc.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class jdkDynamicProxyUtil {

	public static <T>T newProxyInstance(Object obj, InvocationHandler invocationHandler){
		ClassLoader classLoader = obj.getClass().getClassLoader();
		Class<?>[] interfaces = obj.getClass().getInterfaces();
		T object = (T)Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
		return object;
	}
}
