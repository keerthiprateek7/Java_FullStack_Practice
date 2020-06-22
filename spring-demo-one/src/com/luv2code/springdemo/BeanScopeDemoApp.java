package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		//load the spring config
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		// retrieve the bean
		Coach theCoach=context.getBean("myCoach",Coach.class);
		Coach alphaCoach=context.getBean("myCoach",Coach.class);
		
		//check if they are same beans
		boolean result= (theCoach == alphaCoach);
		

		System.out.println("\n Pointing to the same object"+ result);
		System.out.println("\n Memory location to the theCoach"+ theCoach);
		System.out.println("\n Memory location to the alphaCoach"+ alphaCoach);
		
		context.close();
	}

}
