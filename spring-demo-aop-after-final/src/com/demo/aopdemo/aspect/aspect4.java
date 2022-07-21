package com.demo.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4)
public class aspect4 {



	
	@After("com.demo.aopdemo.aspect.annotation.noSetterOrGetter()")
	public void log(JoinPoint j) {
		
		String method = j.getSignature().toString();
		System.out.println("\n\n===========FINALLY" + method);
		
	}
}
