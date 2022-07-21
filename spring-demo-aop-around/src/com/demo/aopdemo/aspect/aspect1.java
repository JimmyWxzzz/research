package com.demo.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.demo.aopdemo.acount.account;


@Aspect
@Component
@Order(1)
public class aspect1 {
	
	@Before("com.demo.aopdemo.aspect.annotation.noSetterOrGetter()")
	public void beforeAddAccountAdvice(JoinPoint j) {
		
		System.out.println("\n=============>>> Executing @1");
		
		MethodSignature methodsig = (MethodSignature) j.getSignature();
		
		System.out.println("\n\n\n\nMethod Signature: " + methodsig + "\n\n\n");
		
		Object[] args = j.getArgs();
		
		for (Object tmp : args) {
			System.out.println("Args are: " + tmp);
			
			if (tmp instanceof account) {
				account tmpaccount = (account) tmp;
				
				System.out.println("\n===================\naccount Name: " + tmpaccount.getName());
			}
		}
		
		
	}
	
}
