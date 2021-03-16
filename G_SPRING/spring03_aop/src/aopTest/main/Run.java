package aopTest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aopTest.vo.Rectangle;
import aopTest.vo.Triangle;

public class Run {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aopTest/main/applicationContext.xml");
		
		Rectangle rectangle = context.getBean("rectangle", Rectangle.class);
		Triangle triangle = context.getBean("triangle", Triangle.class);
		
		
		//applicationContext.xml 에 bean직접 넣어도된다
		//setter 쓰면 안좋다. SpringFramework한테 온전히 객체에 대한 권리를 맡긴게 아니게 된다.
		
		rectangle.setName("네모네모");
		rectangle.setHeight(100);
		rectangle.setWidth(20);
		
		triangle.setName("세모세모");
		triangle.setHeight(100);
		triangle.setWidth(20);
		
		
		rectangle.getArea();
		System.out.println("==========");
		triangle.getArea();
		
	}
}
