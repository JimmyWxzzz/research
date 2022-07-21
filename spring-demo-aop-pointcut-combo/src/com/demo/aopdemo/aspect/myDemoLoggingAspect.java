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
	@Pointcut("execution(* com.demo.aopdemo.dao.*.set*(..))")
	private void getter() {};
	@Pointcut("execution(* com.demo.aopdemo.dao.*.get*(..))")
	private void setter() {};
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	private void noSetterOrGetter() {}
	
	@Before("forDAOPackage() && !(getter() || setter())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=============>>> Executing @Before");
	}
	
//	@Before("forDAOPackage()")
//	public void ddd() {
//		
//		System.out.println("\n=============>>> Executing @Before");
//	}
}
