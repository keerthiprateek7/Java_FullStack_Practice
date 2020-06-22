package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewAspect {
	
	@Pointcut("execution(public void summing())")
	public void forIncreasing() {}
	
	@Before("forIncreasing()")
	public void aspecting() {
		System.out.println("class 1 advice");
	}
	
	@Before("forIncreasing()")
	public void aspectingtwo() {
		System.out.println("class 2 advice");
	}
}
