package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a student object
			System.out.println("Creating new student object...");
			Student tempStudent1 = new Student("Dhoni", "Mahi", "mahi@odu.edu");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent1);
			session.save(tempStudent1);
			
			// commit transaction
			session.getTransaction().commit();
			
			//retrieveing object
			System.out.println("Saved Student Generated id:" + tempStudent1.getId());
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Get Student id:" + tempStudent1.getId());
			Student myStudent=session.get(Student.class,tempStudent1.getId());
			System.out.println(myStudent);
			// commit transaction
			session.getTransaction().commit();
			
			
		}
		finally {
			factory.close();
		}
	}

}





