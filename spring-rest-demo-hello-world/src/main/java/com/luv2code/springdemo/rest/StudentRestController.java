package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		
		//check the studentId against the list size
		if((studentId>=theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found- " + studentId);
		}
		return theStudents.get(studentId);	
	}
	
	//upto now we have done only throwing of exception - now we have to handle it which is done using @Exception Handler
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		//create a studentErrorResponse
		StudentErrorResponse error= new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		//return ResponseEntity
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	//add another exception handler... to catch any exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
		//create a studentErrorResponse
		StudentErrorResponse error= new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
				
				
		//return ResponseEntity
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
}
