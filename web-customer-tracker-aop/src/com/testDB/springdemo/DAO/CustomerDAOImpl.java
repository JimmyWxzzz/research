package com.testDB.springdemo.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.testDB.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomer() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",
															  Customer.class);
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session currSession = sessionFactory.getCurrentSession();
		
		currSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		Session curr = sessionFactory.getCurrentSession();
		
		Customer cus = curr.get(Customer.class, id);
		
		return cus;
	}

	@Override
	public void deleteCustomer(int id) {
		Session curr = sessionFactory.getCurrentSession();
		
		Customer cus = curr.get(Customer.class, id);
		
		curr.delete(cus);
		
		
		Query q = curr.createQuery("delete from Customer where id=:customerId");
		
		q.setParameter("customerId", id);
		
		q.executeUpdate();
	}

}
