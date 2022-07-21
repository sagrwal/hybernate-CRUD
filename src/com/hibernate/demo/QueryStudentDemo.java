package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		//SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();//default
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//query student 
			List<Student> theStudents = session.createQuery("from Student").list(); 
			
			//display the student ==>refactor
			/* for(Student tempStudent : theStudents){
			 * System.out.println(tempStudent);
			 */
			
			displayStudent(theStudents);
			
			System.out.println("--------------------------------------");
			//query students : lastName='Doe'
			theStudents= session.createQuery("from Student s where s.lastName='Doe'").list();
			System.out.println("\n\nStudents who have last name of Doe ");
			displayStudent(theStudents);
			
			System.out.println("----------------------------------------");
			//query Students: lastName='Doe' OR firstName='Daffy'
			theStudents= session.createQuery("from Student s where"
					+" s.lastName='Doe' OR s.firstName='Daffy'").list();
			
			System.out.println("\n\nStudents who have last name of Doe OR first name Daffy ");
			displayStudent(theStudents);
			System.out.println("-----------------------------------------");
			
			//query Students where email like 'k@lu2code.com'
			theStudents = session.createQuery("from Student s where"
					  +" s.email LIKE '%k@lu2code.com'").list();
			
			System.out.println("\n\nStudents whose email ends with k@lu2code.com");
			displayStudent(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!..s");
			
			
		}finally {
			factory.close();
			session.close();
		}
		

	}

	private static void displayStudent(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
