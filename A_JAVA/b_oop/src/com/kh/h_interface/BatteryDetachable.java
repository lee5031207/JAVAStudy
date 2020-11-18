package com.kh.h_interface;

// 모든 메서드가 추상 메서드인 추상 클래스 = 인터페이스
// 인스턴스 생성 x , 
// 모두 추상 메서드이니 메서드 구현부가 없음
// interface는 다중 구현이 가능하다
// 인터페이스는 인터페이스를 구현하는 모든 클래스가 지켜야하는 공통의 규약
public interface BatteryDetachable {
	
	//인터페이스의 필드 변수는 묵시적으로 publicc static final 이다
	String ABOUINFO = "배터리를 탈부착 할 수 있는 제품입니다";
	
	//인터페이스 메서드는 묵시적으로 public abstract 메서드이다
	void detachBattery();	
	void attachBattery();
	
	//deafult 메서드가 새로도입
	default void info() {
		System.out.println(ABOUINFO);
	}
}
