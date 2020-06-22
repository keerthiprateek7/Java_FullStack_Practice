package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			// start a transaction
			session.beginTransaction();
			
			//option:2 Hibernate query with sql
			
			// get the instructor from db
			int theId = 1;
			
			Query<Instructor> query=session.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId",Instructor.class);
			//Instructor tempInstructor = session.get(Instructor.class, theId);		
			
			query.setParameter("theInstructorId", theId);
			Instructor tempInstructor=query.getSingleResult();
			System.out.println("luv2code: Instructor: " + tempInstructor);
			
			// get courses for the instructor
			//System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("luv2code: Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}




