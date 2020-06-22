package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.index.processor.CandidateComponentsIndexer;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// read spring config java class 
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SportConfig.class);
		
		// retrieve bean from container
		Coach theCoach=context.getBean("thatSillyCoach",Coach.class);
		
		//call method
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		
		// close the context
		context.close();

	}

}
