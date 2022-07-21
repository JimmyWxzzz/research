package com.demo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;

public class testBi {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

// create session
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		try {
		int id=2;
		InstructorDetail tempInsDetail = session.get(InstructorDetail.class, id);
		
		System.out.println("tempInsDetail: " + tempInsDetail);
		System.out.println("tempInsDetail with Ins: " + tempInsDetail.getInstructor());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
		
		
	}

}
