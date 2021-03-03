package com.imooc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
	@Pointcut("execution(* com.imooc.service..*.*(..))")
	public void embed() {
	}

	@Before("embed()")
	public void before(ProceedingJoinPoint joinPoint) {
		System.out.println("开始调用" + joinPoint);
	}

	@After("embed()")
	public void after(ProceedingJoinPoint joinPoint) {
		System.out.println("开始调用" + joinPoint);
	}

	@Around("embed()")
	public Object aroundMe(ProceedingJoinPoint joinPoint){
		long startTime = System.currentTimeMillis();
		Object resultValue= null;
		System.out.println("开始计时" + joinPoint);
		try {
			resultValue = joinPoint.proceed();
			System.out.println("执行完成,结束计时" + joinPoint);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			System.out.println("执行失败，结束计时" + joinPoint);
		}finally {
			long endTime = System.currentTimeMillis();
			System.out.println("总共耗时" + (endTime - startTime) + "ms");
			return resultValue;
		}
	}
}

