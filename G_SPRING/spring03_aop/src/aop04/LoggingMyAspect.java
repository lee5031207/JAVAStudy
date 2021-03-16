package aop04;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect //해당 클래스를 Advisor로 만들어주는 어노테이션
public class LoggingMyAspect {
	
	@Before("execution(* aop04.*.*(..))")
	public void argCheck(JoinPoint join) {
		System.out.println("target : " + join.getArgs().getClass());
		System.out.println("method : " + join.getSignature());
		for (Object o : join.getArgs()) {
			System.out.println("[ [args : " + o + "] ]");	
		}
	}
	
	@AfterReturning(pointcut = "execution(* aop04.*.*(..))"
			, returning = "res")
	public void returnCheck(Object res) {
		System.out.println("return : " +res);
	}

	
}
