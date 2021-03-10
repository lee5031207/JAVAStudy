package templateMethod.client;

import templateMethod.framework.dao.MemberDao;

public class Run {

	//templateMethod 패턴
	//사용자가 상속받아야 하는 추상클래스에 사용자가 작성해야 하는 로직을 제외한 전체 로직을 작성하고
	//사용자가 작성해야 하는 로직을 작성할 메서드를 추상메서드로 만들어두는 방식
	//사용자가 추상클래스를 상속받아 추상클래스를 구현함으로써 전체 로직이 완성된다.
	//단점 : 클래스 상속이 강제되어, 사용자가 객체지향적으로 설계하기 힘들게 만듦
	
	public static void main(String[] args) {
		String password = new MemberDao(new MyTemplate()).selectPassword("pclass");
		System.out.println(password);
	}

}
