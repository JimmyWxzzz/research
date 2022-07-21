package com.testDB.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	private Logger mylogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.testDB.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.testDB.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.testDB.springdemo.DAO.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	
	@Before("forAppFlow()")
	public void before(JoinPoint j) {
		
		String method = j.getSignature().toShortString();
		mylogger.info("\n\n@Before calling:" + method );
		
		Object[] args = j.getArgs();
		for (Object tmp: args) {
			
			mylogger.info("========>Args: " + tmp);
		}
	}
	
	@AfterReturning(pointcut="forAppFlow()", returning="result")
	public void afterReturning(JoinPoint j, Object result) {
		String method = j.getSignature().toShortString();
		mylogger.info("\n\n@AfterReturning calling:" + method );
		
		mylogger.info("==========> result: " + result);
	}
}
