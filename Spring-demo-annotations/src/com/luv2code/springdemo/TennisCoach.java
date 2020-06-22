package com.luv2code.springdemo;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.index.processor.CandidateComponentsIndexer;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {
	private FortuneService fortuneService;
	
	/* This is for autowired constructor injection
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService=theFortuneService;
	} */
	
	//this for autowired setter class injection
	//default constructor
	public TennisCoach() {
		System.out.println("Tennis Coach:Inside Default Constructor");
	}
	
	//setter method for injection
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println("Tennis Coach:Inside setter method");
		fortuneService =theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice you backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
