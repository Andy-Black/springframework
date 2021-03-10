package com.imooc.proxy.jdkProxy;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AliPayInvocationHandler implements InvocationHandler {

	private Object objectTarget;

	public AliPayInvocationHandler(Object objectTarget) {
		this.objectTarget = objectTarget;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		beforePay();
		Object result = method.invoke(objectTarget, args);
		afterPay();
		return result;
	}

	private void beforePay() {
		System.out.println("从招行取款");
	}

	private void afterPay() {
		System.out.println("支付给慕课网");
	}
}
