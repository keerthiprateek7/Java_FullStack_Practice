package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//define @PostConstruct --> will be called only once when the bean is created
	@PostConstruct
	public void loadData() {
		
		theStudents= new ArrayList<>();
		theStudents.add(new Student("Prateek","Keerthi"));
		theStudents.add(new Student("Dhoni","Mahi"));
		theStudents.add(new Student("Raina","SUresh"));
	}
	
	//define endpoint for /students -> return list of students
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return theStudents;
	}
	
	//endpoint for single student "/students/{studentId}"
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		return theStudents.get(studentId);
		
	}
}
