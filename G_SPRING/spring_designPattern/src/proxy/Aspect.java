package proxy;

import java.lang.reflect.InvocationTargetException;

public class Aspect implements Developer{

	private Developer developer;
	
	//자바 reflection : 런타임시 바이트를 조작하여 코드를 새롭게 구성
	//				   런타임시에 동적으로 객체를 생성하는게 가능
	
	public Aspect(String className) {
//		switch(className) {
//		case "man":
//			developer = new Man();
//			break;
//		case "woman":
//			developer = new Woman();
//			break;
//		default : 
//			System.out.println("잘못된 클래스명을 입력하셨습니다.");
//		}
		try {
			this.developer = (Developer) Class.forName(className).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void develop() {
		System.out.println("출근 카드를 찍는다");
		try {
			developer.develop();
		} catch (Exception e) {
			System.out.println("쉬는 날이었다.");
		} finally {
			System.out.println("퇴근");
		}
	}

}