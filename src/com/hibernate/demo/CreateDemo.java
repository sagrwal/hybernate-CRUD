package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.*;
import com.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		//SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();//default
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
		
			//create the objects
			/*Instructor tempInstructor = new Instructor("Sakshi","Agrawal","sagrawal@123.net");
			
			
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("KinkariTheWorld","sketche");
			
			*/
			Instructor tempInstructor = new Instructor("Shikha","Agrawal","skagrawal@123.net");
			
			
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("TheWorld","singing");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			//start a transaction
			session.beginTransaction();
			
			//save the instruction
			//Note: this will also save the details object because of CascadeType.All
			
			System.out.println("Saving instructor:"+tempInstructor);
			session.save(tempInstructor);
			
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!..s");
			
			
		}finally {
			factory.close();
			session.close();
		}
		

	}

}
