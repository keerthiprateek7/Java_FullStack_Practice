package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	//add a new advice @AfterReturning on the findAccounts method
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..)) ",
			returning="result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result ) {
		
		//print out which method we are advising on
		String method=theJoinPoint.getSignature().toShortString();
		//MethodSignature method=(MethodSignature) theJoinPoint.getSignature();
		System.out.println("\n============>Executing @AfterReturning on method: "+method);
		
		//print out the results of the method call
		System.out.println("\n============>Result is: "+result);	
		
		
		//post process the data: lets modify the data
		//convert the account name to Upper case
		convertAccountNamesToUpperCase(result);
		System.out.println("\n============>Result is: "+result);	
	}
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		//loop through accounts
		for(Account tempAccount:result) {
			
			//get uppercase version of name
			String theUpperName=tempAccount.getName().toUpperCase();
		    
			//update the name on the account
			tempAccount.setName(theUpperName);
		}
		
		
		
		
	}


	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {		
		System.out.println("\n=====>>> Executing @Before advice on method");		
	
	//display method signature
	MethodSignature methodSig=(MethodSignature) theJoinPoint.getSignature();
	System.out.println("Method: "+ methodSig);	
    
	//display method arguments
	//get args
	Object[] args=theJoinPoint.getArgs();
	
	//loop through args
	for(Object tempArg:args) {
		System.out.println(tempArg);
		
		if(tempArg instanceof Account) {
			//downcast and print account specific stuff
			Account theAccount=(Account) tempArg;
			System.out.println("account name: " +theAccount.getName());
			System.out.println("account level: " +theAccount.getLevel());
			
		}
	}
	}
	
}










