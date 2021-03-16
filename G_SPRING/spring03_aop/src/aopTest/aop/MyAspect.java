package aopTest.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	@Before("execution(* aopTest..*.getArea(..))")
	public void before() {
		System.out.println("도형의 넓이를 구합니다.");
	}
	 
	@After("execution(* aopTest..*.getArea(..))")
	public void after() {
		System.out.println("도형의 넓이를 구했습니다.");
	}
	
	@AfterReturning(pointcut = "execution(* aopTest..*.getArea(..))"
			, returning = "res")
	public void afterReturning(Object res) {
		System.out.println("넓이 : " +res);
	}
	
	
}
