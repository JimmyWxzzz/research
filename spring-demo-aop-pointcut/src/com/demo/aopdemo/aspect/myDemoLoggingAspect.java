package com.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class myDemoLoggingAspect {
	
	@Pointcut("execution(* com.demo.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {};
	
	@Before("forDAOPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=============>>> Executing @Before");
	}
	
	@Before("forDAOPackage()")
	public void ddd() {
		
		System.out.println("\n=============>>> Executing @Before");
	}
}
