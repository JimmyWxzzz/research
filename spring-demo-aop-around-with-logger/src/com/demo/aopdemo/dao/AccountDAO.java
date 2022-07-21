package com.demo.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.aopdemo.acount.account;

@Component
public class AccountDAO {
	
	
	private String name;
	
	public List<account> findAccounts(boolean tripwire) {
		List<account> acc = new ArrayList<>();
		
		if (tripwire) {
			throw new RuntimeException("DONE!");
		}

		account tmp1 = new account("Jim");
		account tmp2 = new account("Dud");
		account tmp3 = new account("Bibu");
		
		acc.add(tmp1);
		acc.add(tmp2);
		acc.add(tmp3);
		return acc;
	}
	
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
