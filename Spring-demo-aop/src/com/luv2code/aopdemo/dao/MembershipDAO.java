package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addAccount() {
		System.out.println("class: " + getClass() +" Doing my DB work: Creating membership account");
	}
}
