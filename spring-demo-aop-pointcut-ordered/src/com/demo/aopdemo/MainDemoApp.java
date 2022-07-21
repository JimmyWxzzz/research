package com.demo.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.aopdemo.acount.account;
import com.demo.aopdemo.dao.AccountDAO;
import com.demo.aopdemo.dao.membershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(demoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		theAccountDAO.addAccount();
		
		membershipDAO theMembershipDAO = context.getBean("membershipDAO", membershipDAO.class);
		
		account l = new account();
		theAccountDAO.setName("Jim");
		String name = theAccountDAO.getName();
		theMembershipDAO.addAccount(l);
		context.close();
	}

}
