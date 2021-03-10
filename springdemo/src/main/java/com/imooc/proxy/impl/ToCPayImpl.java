package com.imooc.proxy.impl;

import com.imooc.proxy.ToCPay;

public class ToCPayImpl implements ToCPay {
	@Override
	public void pay() {
		System.out.println("个人名义支付");
	}
}
