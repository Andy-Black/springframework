package com.imooc.aspect;

import org.aspectj.lang.JoinPoint;
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
	public void before(JoinPoint joinPoint) {
		System.out.println("开始调用" + joinPoint);
	}

	@After("embed()")
	public void after(JoinPoint joinPoint) {
		System.out.println("开始调用" + joinPoint);
	}

	@Around("embed()")
	public Object aroundMe(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object resultValue= null;
		System.out.println("开始计时" + joinPoint);
			resultValue = joinPoint.proceed();
			System.out.println("执行完成,结束计时" + joinPoint);
			System.out.println("执行失败，结束计时" + joinPoint);
			long endTime = System.currentTimeMillis();
			System.out.println("总共耗时" + (endTime - startTime) + "ms");
			return resultValue;
	}

	@AfterReturning(pointcut = "embed()", returning = "returnValue")
	public void afterReturning(JoinPoint joinPoint, Object returnValue){
		System.out.println("无论是空还是有值都返回 " + joinPoint + "返回值[" + returnValue + "]");
	}

	@AfterThrowing(pointcut = "embed()", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception){
		System.out.println("抛出异常通知 " + joinPoint + " " + exception.getMessage());
	}
}

