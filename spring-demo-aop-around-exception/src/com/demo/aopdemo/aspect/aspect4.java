package com.demo.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4)
public class aspect4 {
	
	@Around("com.demo.aopdemo.aspect.annotation.noSetterOrGetter()")
	public Object around(ProceedingJoinPoint j)throws Throwable {
		
		String method = j.getSignature().toString();
		System.out.println("\n\n===========AROUND" + method);
		
		Object result = null;
		
		long begin = System.currentTimeMillis();
		
		try {
			result = j.proceed();
		}
		catch (Exception e) {
			
			throw e;
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("\n\nDUREATION===============" + (begin-end)/1000);
		return result;
	}

	
	@After("com.demo.aopdemo.aspect.annotation.noSetterOrGetter()")
	public void log(JoinPoint j) {
		
		String method = j.getSignature().toString();
		System.out.println("\n\n===========FINALLY" + method);
		
	}
}
