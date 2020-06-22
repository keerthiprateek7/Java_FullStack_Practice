package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {
	
	private String[] data= {
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	private Random rand = new Random();

	@Override
	public String getFortune() {
		int index = rand.nextInt(2);
		System.out.println(index);
		
		String fortuneVariable=data[index];
		return fortuneVariable;
	}

}
