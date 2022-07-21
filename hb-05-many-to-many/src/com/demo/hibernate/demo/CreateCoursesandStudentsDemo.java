package com.demo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Course;
import com.demo.hibernate.entity.Instructor;
import com.demo.hibernate.entity.InstructorDetail;
import com.demo.hibernate.entity.Review;
import com.demo.hibernate.entity.Student;

public class CreateCoursesandStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			

			session.beginTransaction();
			
			Course tmpCourse = new Course("Pacman");
			session.save(tmpCourse);
			
			Student tmpStudent1 = new Student("Jim", "Wang", "jJJJ@gmail.com");
			Student tmpStudent2 = new Student("sdsd", "dss", "dudde@gmail.com");
			
			tmpCourse.addStudent(tmpStudent1);
			tmpCourse.addStudent(tmpStudent2);
			
			session.save(tmpStudent1);
			session.save(tmpStudent2);
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





