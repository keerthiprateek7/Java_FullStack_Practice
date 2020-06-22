package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is where we add all of our related advices for logging
    
	//starting with an @Before advice
	
	//@Before("execution(public void addAccount())")
	//@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n =====> executing @Before advice");
	}
	
	@Before("execution(public void summing())")
	public void LogginAspect() {
		System.out.println("\n =====> executing @Before logging advice");
	}
}
