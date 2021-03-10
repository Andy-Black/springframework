package com.imooc.proxy;

import com.imooc.proxy.impl.ToCPayImpl;
import com.imooc.proxy.jdkProxy.AliPayInvocationHandler;
import com.imooc.proxy.jdkProxy.jdkDynamicProxyUtil;

import java.lang.reflect.InvocationHandler;

public class ProxyTest {
	public static void main(String[] args) {
//		ToCPay toCPay = new AliPayToC(new ToCPayImpl());
//		toCPay.pay();

		ToCPay toCPay = new ToCPayImpl();
		InvocationHandler invocationHandler = new AliPayInvocationHandler(toCPay);
		ToCPay o = jdkDynamicProxyUtil.newProxyInstance(toCPay, invocationHandler);
		o.pay();
	}
}
