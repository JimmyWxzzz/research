package com.testDB.springdemo.DAO;

import java.util.List;



import com.testDB.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomer();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
