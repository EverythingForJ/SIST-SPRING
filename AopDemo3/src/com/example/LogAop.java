package com.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAop {

	@Pointcut("within(com.example.*)*")
	private void pointcutMethod() {
	}

	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + " is start.");
		long start = System.currentTimeMillis();
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long end = System.currentTimeMillis();
			System.out.println(signatureStr + " is finished.");
			System.out.println(signatureStr + " 경과시간 : " + (end - start));
		}
	}

	@Before("within(com.example.*)*")
	public void beforeAdvice() {
		System.out.println("Called beforeAdvice()");
	}
}
