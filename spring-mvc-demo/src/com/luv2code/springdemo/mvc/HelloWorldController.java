package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a controller method to show initial Html form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the form 
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//need a controller method to read form data and 
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request,Model model) {
		//read the request parameter from html form
		String theName=request.getParameter("studentName");
		
		//convert data
		theName=theName.toUpperCase();
		
		//create the message
		String result="yo! " + theName;
		model.addAttribute("message",result);
		return "helloworld";
	}
	
	//need a controller method to read form data and 
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName,Model model) {
			
		//convert data
		theName=theName.toUpperCase();
		
		//create the message
		String result="Hey My Friend! " + theName;
		model.addAttribute("message",result);
		return "helloworld";
	}
		
}
