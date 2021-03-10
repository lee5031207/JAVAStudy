package bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean/applicationContext.xml");
		
		Address lee = (Address) context.getBean("Lee");
		Book hopeForTheFlower = context.getBean("hopeForTheFlower", Book.class);
		Address hong = context.getBean("hong", Address.class);
		Book jungle = context.getBean("jungle", Book.class);
		
		System.out.println(lee);
		System.out.println(hopeForTheFlower);
		System.out.println(hong);
		System.out.println(jungle);
		
		

	}

}
