package com.luv2code.jackson.json.demo;

import java.io.File;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			ArrayList<String> list=new ArrayList<String>();
			
			//create object mapper
			ObjectMapper mapper=new ObjectMapper();
			
			//read Json file and map/convert to Java POJO: data/sample-lite.json
			Student theStudent=mapper.readValue(new File("data/sample-full.json"),Student.class);
			
			//print first name and last name
			System.out.println("First Name= "+ theStudent.getFirstName());
			System.out.println("Last Name= "+ theStudent.getLastName());
			System.out.println("Active= "+ theStudent.isActive());
			System.out.println("Street= "+ theStudent.getAddress().getStreet());
			System.out.println("City= "+ theStudent.getAddress().getCity());
			for (String tempLang:theStudent.getLanguages())
				list.add(tempLang);
			System.out.println("Languages= "+ list);
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
