package com.kh.g_abstract.sports;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. 추상클래스로 인스턴스를 만들 수 있을까?
		//Sports sports = new Sports(); // 불가능
		
		//2. 추상클래스 타입으로 추상클래스를 상속받은 클래스의 인스턴스를 다룰수 있을까?
		Sports[] sportArr = { new BasketBall(),new FootBall() };
		
		for(int i=0; i<sportArr.length; i++) {
			sportArr[i].rule();
		}
		
	}

}
