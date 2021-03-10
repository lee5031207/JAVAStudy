package strategy.client;

import strategy.framework.dao.MemberDao;

public class Run {

	//strategy 패턴
	//사용자가 구현해야하는 로직을 정의할 메서드를 선언한 인터페이스를 만들고
    //인터페이스의 구현체를 사용자로부터 전달받아 전체 context를 완성하는 디자인 패턴
    //Framework는 사용자의 구현체에 의존하고 있으며, 외부로 부터 구현체(의존대상)을 주입받는다.
	
	public static void main(String[] args) {
		
		String password = new MemberDao(new MyTemplate()).selectPassword("pclass");
		System.out.println(password);
	}

}
