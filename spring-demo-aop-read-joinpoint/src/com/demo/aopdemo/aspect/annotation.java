package com.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class annotation {
	
	
	@Pointcut("execution(* com.demo.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {};
	@Pointcut("execution(* com.demo.aopdemo.dao.*.set*(..))")
	public void getter() {};
	@Pointcut("execution(* com.demo.aopdemo.dao.*.get*(..))")
	public void setter() {};
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void noSetterOrGetter() {}
	
}
