package com.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class aspect2 {

	
	@AfterReturning("com.demo.aopdemo.aspect.annotation.noSetterOrGetter()")
	public void Analytics() {
		
		System.out.println("\n=============>>> Executing @2");
	}
}
