package com.demo.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class aspect3 {



	
	@AfterThrowing(pointcut="com.demo.aopdemo.aspect.annotation.noSetterOrGetter()",
			throwing="result")
	public void log(JoinPoint j, Throwable result) {
		
		String method = j.getSignature().toString();
		System.out.println("\n\n" + method);
		System.out.println("\n\n" + result);
		
	}
}
