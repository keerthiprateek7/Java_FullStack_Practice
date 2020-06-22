package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		//load the spring config
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("beanlifecycleapplicationContext.xml");
		
		// retrieve the bean
		Coach theCoach=context.getBean("myCoach",Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		
		//close the context
		context.close();
	}

}
