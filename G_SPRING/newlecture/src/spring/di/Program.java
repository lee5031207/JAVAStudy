package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.Console;
import spring.di.ui.GridConsole;
import spring.di.ui.InlineConsole;

public class Program {

	public static void main(String[] args) {
		

		// console이라는 클래스를 만드는데 new 연산자를 활용해 만들었다 그동안 (직접 DI를 하는것)
		// 하지만 이것은 너무 결합도가 높다 -> 그러므로 저것을 xml, annotation으로 할 수 있도록 하겠다.
		
		/* 스프링에게 지시하는 방법으로 코드를 변경 -> setting.xml에 bean 작성
		Exam exam = new NewlecExam();
		Console console = new GridConsole();
		
		console.setExam(exam);
		*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/di/setting.xml");
		Console console = (Console) context.getBean("console"); // bean의 id로 가져온거니까 캐스팅해야댐
		//Console console = context.getBean(Console.class); // bean의 class로 가져온거 같은 클래스의 bean을 가져옴
		console.print();
		
		
	}
}
