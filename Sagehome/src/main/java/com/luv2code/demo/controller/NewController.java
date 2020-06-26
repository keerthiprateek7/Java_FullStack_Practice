package com.luv2code.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewController {
	
	@GetMapping("/")
	public String homePage() {
		return "home";
	}
}
