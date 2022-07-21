package com.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(1)
public class aspect1 {
	
	@Before("com.demo.aopdemo.aspect.annotation.forDAOPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=============>>> Executing @1");
	}
	
}
