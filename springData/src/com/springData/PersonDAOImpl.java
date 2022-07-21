package com.springData;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PersonDAOImpl implements PersonDAO {
	
	@PersistenceContext
	private EntityManager m;
	
	@Override
	public void test() {
		Person person = m.find(Person.class, 7852050);
		System.out.println("PERSON: " + person);
	}

}
