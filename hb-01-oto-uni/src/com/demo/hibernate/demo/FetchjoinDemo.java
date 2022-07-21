package com.demo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;
import com.demo.hibernate.entity.Student;

public class FetchjoinDemo {

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
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "+
															"JOIN FETCH i.courses "+
															"where i.id=:theInstructorId", 
															Instructor.class);

			query.setParameter("theInstructorId", id);
			
			Instructor tmpInstructor = query.getSingleResult();
			System.out.println("==========instructor: " + tmpInstructor);
			
			
			
			
			
			session.getTransaction().commit();
			session.disconnect();
			
			
			
			System.out.println("============Done!");
			
			System.out.println("==========instructor: " + tmpInstructor.getCourses());
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





