package com.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class aspect3 {



	
	@Before("com.demo.aopdemo.aspect.annotation.forDAOPackage()")
	public void log() {
		
		System.out.println("\n=============>>> Executing @3");
	}
}
