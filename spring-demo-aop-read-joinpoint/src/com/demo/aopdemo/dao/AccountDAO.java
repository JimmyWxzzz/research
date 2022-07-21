package com.demo.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	
	private String name;
	
	public AccountDAO() {

	}
	public AccountDAO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addAccount() {
		
		System.out.println(getClass() + " Creating account======");
	}
}
