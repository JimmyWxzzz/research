package com.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class aspect2 {

	
	@Before("com.demo.aopdemo.aspect.annotation.forDAOPackage()")
	public void Analytics() {
		
		System.out.println("\n=============>>> Executing @2");
	}
}
