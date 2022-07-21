package com.demo.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.aopdemo.acount.account;
import com.demo.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(demoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<account> accounts = null;
		try {
			boolean tripwire = true;
			accounts = theAccountDAO.findAccounts(tripwire);
		}
		catch (Exception e) {
			
			System.out.println("===========" + e);
		}
		
		System.out.println("After throwing------------");
		System.out.println("\n" + accounts);
		
		context.close();
	}

}
