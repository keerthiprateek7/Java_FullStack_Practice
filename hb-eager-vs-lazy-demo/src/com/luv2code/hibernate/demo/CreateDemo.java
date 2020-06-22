package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
//import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

import java.util.List;



public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
		
			// start a transaction
			session.beginTransaction();
			
			//create the objects
			Instructor tempInstructor= new Instructor("prateek","keerthi","pkeer001@odu.edu");
			InstructorDetail tempInstructorDetail = new InstructorDetail("prateekyoutube.com","coding");
			
			//Assosciate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//save the instructor
			//beacuse of cascadetype.all
			System.out.println("saving instructor:" + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
	
	


}




