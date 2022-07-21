package com.demo.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.demo.aopdemo.acount.account;


@Aspect
@Component
@Order(2)
public class aspect2 {

	
	@AfterReturning(pointcut="com.demo.aopdemo.aspect.annotation.noSetterOrGetter()",
			returning="result")
	public void Analytics(JoinPoint j, List<account> result) {
		
		String method = j.getSignature().toString();
		System.out.println("\n\n" + method);
		System.out.println("\n\n" + result);
		
		convertToUpperCase(result);
	}

	private void convertToUpperCase(List<account> result) {
		
		for (account tmp : result) {
			String Name = tmp.getName().toUpperCase();
			tmp.setName(Name);
		}
		
	}
}
