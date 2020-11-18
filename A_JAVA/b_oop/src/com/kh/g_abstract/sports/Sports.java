package com.kh.g_abstract.sports;

//추상 클래스
//클래스의 선언부에 abstract 예약어 사용
//추상클래스는 abstract 메서드가 0개이상 존재하는 클래스
//    * 일반클래스는 abstract 메서드가 0개인 클래스
//      abstract메서드가 하나라도 있으면 반드시 추상클래스
//abstract 메서드 : 메서드 선언부만 존재하는 메서드 . 메서드 선언부에 abstract 예약어를 사용해서 생성
//추상클래스는 미완성 클래스 이므로 , 인스턴스화 불가능 하다.
//추상클래스를 상속받은 클래스가 추상메서드를 오버라이드 함으로써 추상클래스가 완성
//추상클래스의 추상메서드는 자식 클래스가 ****무조건 override해야함

//****상속을 시키려고 만든다 
public abstract class Sports {

	private int peopleCnt;
	
	public Sports() {
		
	}

	public Sports(int peopleCnt) {
		super();
		this.peopleCnt = peopleCnt;
	}

	public int getPeopleCnt() {
		return peopleCnt;
	}

	public void setPeopleCnt(int peopleCnt) {
		this.peopleCnt = peopleCnt;
	}

	@Override
	public String toString() {
		return "Sports [peopleCnt=" + peopleCnt + "]";
	}
	
	//추상 메서드 
	//스포츠마다 규칙이 있지만 내용은 모두 다르다
	//스포츠를 상속받는 모든 자식클래스에서 규칙을 재정의하도록 강제하는것	
	public abstract void rule();
	
	
}
