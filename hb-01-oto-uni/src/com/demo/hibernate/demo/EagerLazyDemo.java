package com.demo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;
import com.demo.hibernate.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			int id = 1;
			session.beginTransaction();
			Instructor tmpInstructor = session.get(Instructor.class, id);

			System.out.println("==========instructor: " + tmpInstructor);
			session.getTransaction().commit();
			session.close();
			
			System.out.println("==========courses: " + tmpInstructor.getCourses());
			
			
			System.out.println("============Done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





