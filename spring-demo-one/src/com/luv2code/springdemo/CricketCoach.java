package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//add new fields
	private String emailaddress;
	private String teamname;
	
	

	public String getEmailAddress() {
		return emailaddress;
	}

	public void setEmailAddress(String emailaddress) {
		System.out.println("Cricket Coach:Inside setter method: setEmailAddress");
		this.emailaddress = emailaddress;
	}

	public String getTeamName() {
		return teamname;
	}

	public void setTeamName(String teamname) {
		System.out.println("Cricket Coach:Inside setTeam");
		this.teamname = teamname;
	}

	//create no arg constructor
	public CricketCoach() {
		System.out.println("Cricket Coach:Inside no-arg Container");
	}
	
	//Our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket Coach:Inside Setter Method Container");
		this.fortuneService = fortuneService;
	}


	@Override
	public String getDailyWorkout() {
		return "Practice bowling for 15 min";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
