package com.demo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;
import com.demo.hibernate.entity.Review;

public class CreateCoursesandReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			

			session.beginTransaction();
			
			Course tmpCourse = new Course("Pacman");
			
			tmpCourse.addReview(new Review("What a great course"));
			tmpCourse.addReview(new Review("DoneZOOO"));
			tmpCourse.addReview(new Review("NIceONe"));
			
			System.out.println(tmpCourse);
			System.out.println(tmpCourse.getReviews());
			
			session.save(tmpCourse);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





