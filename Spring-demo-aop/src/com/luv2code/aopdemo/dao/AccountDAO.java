package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	public void addAccount() {
		System.out.println("class: " + getClass() +" Doing my DB work: adding an account");
	}
	
	public void summing() {
		System.out.println("My name is prateek");
	}
}
