package com.imooc.proxy;

public class AliPayToC implements ToCPay{
	ToCPay toCPay;

	public AliPayToC(ToCPay toCPay) {
		this.toCPay = toCPay;
	}

	@Override
	public void pay() {
		beforePay();
		toCPay.pay();
		afterPay();
	}

	private void beforePay(){
		System.out.println("从招行取款");
	}

	private void afterPay(){
		System.out.println("支付给慕课网");
	}

}
