package com.demo.hibernate.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		try {
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			Date date;
			try {
				date = simpleDateFormat.parse("2018-09-09");

				Student tmp = session.get(Student.class,1);
				Student tmp1 = new Student(date, "cc", "cc@gmail.com");
				Student tmp2 = new Student(date, "dd", "dd@gmail.com");
				Student tmp3 = new Student(date, "ee", "ee@gmail.com");
				Student tmp4= new Student(date, "ff", "ff@gmail.com");
				Student tmp5 = new Student(date, "gg", "gg@gmail.com");
				
				session.delete(tmp);
			
				session.getTransaction().commit();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





