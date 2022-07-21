package com.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class myDemoLoggingAspect {
	
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=============>>> Executing @Before");
	}
}
