package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DBConnectionAspect {
	
	@Pointcut("execution(* *.getConnection(..))")
	private void myCustomPointCut(){
		
	}

	@Before("myCustomPointCut()")
	private void beforeAdvice(){
		System.out.println("Running before Advice : DBConnectionAspect");
	}
	@After("myCustomPointCut()")
	private void afterAdvice(){
		System.out.println("Running after Advice : DBConnectionAspect");
	}
	
	@Around("myCustomPointCut()")
	private void aroundAdvice(ProceedingJoinPoint point){
		System.out.println("In Around Advice before method Execution");
		try {
			point.proceed();
		} catch (Throwable e) {
			System.out.println("Exception in procedding");
		}
		System.out.println("In Around Advice after method Execution");
	}
}
