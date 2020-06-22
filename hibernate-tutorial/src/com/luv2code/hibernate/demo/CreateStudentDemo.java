package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.luv2code.hibernate.demo.entity.Student;

import java.util.List;



public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
		
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents =session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			System.out.println("Students with last name mahi");
			
			//Query Students: lastName="Doe"
			List<Student> theStudents1=  session.createQuery("from Student s where s.lastName='Keerthi'").getResultList();
			displayStudents(theStudents1);
			
			// query students: lastName='Mahi' OR firstName='Prateek'
			theStudents = session.createQuery("from Student s where s.lastName='Mahi' OR s.firstName='Prateek'").getResultList();
			System.out.println("\n\nStudents who have last name of Mahi OR first name Prateek");
			displayStudents(theStudents);
			
			// query students where email LIKE '%gmail.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%odu.edu'").getResultList();
			System.out.println("\n\nStudents whose email ends with odu.edu");			
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
	
	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}


}




