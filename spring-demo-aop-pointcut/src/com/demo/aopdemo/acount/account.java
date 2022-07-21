package com.demo.aopdemo.acount;

import org.springframework.stereotype.Component;

@Component
public class account {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "account [name=" + name + "]";
	}

	public account(String name) {
		super();
		this.name = name;
	}
	
	public account() {
		
	}
	
	
}
