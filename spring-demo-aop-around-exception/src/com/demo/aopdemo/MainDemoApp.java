package com.demo.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.aopdemo.service.TrafficFortuneService;

public class MainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(demoConfig.class);
		
		TrafficFortuneService f = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		String s = f.getFortune();
		
		System.out.println("\n\n" + s);
		
		context.close();
	}

}
