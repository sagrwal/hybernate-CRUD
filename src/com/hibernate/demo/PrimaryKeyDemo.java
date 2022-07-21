package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	
	public static void main(String[] args) {
		//create session factory
				//SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();//default
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try {
				
					//create 3 student object
					System.out.println("Creating 3 student object...");
					Student tempStudent1 = new Student("john","Doe","john@lu2code.com");
					Student tempStudent2 = new Student("Ramu","shivas","ramu@lu2code.com");
					Student tempStudent3 = new Student("sharuk","Khan","sharuk@lu2code.com");
					
					//start a transaction
					session.beginTransaction();
					
					//save the student object
					System.out.println("Saving the student...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!..s");
					
					
				}finally {
					factory.close();
					session.close();
				}
				
	}

}
