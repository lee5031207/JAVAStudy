package com.kh.e_inheritance.override;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book1 = new Book("수학의 정석", "이성욱", 32000);
		Book book2 = new Book("국어의 정석", "이성욱", 23000);
		Book book3 = new Book("혼자 공부하는 파이썬", "윤인성", 30000);
		Book book4 = new Book("수학의 정석", "이성욱", 32000);
		
		//1. Object.toString()
		//오버라이드 전 : 클래스 전체 이름 + 객체의 주소값을 16진수로 변환해 출력
		//오버라이드 후 : 생성한 인스턴스의 속성 정보가 출력
		System.out.println(book1.toString());
		System.out.println(book2);
		
		//2. Object.equals(Object obj)
		//오버라이드 전 : 주소값이 일치하는 지 비교한다. 네이티브 : java가 아닌 다른 언어로 작성된 함수 , 동일 객체 인지
		//오버라이드 후 : 주소값이 다르더라도 속성 값이 일치하면 같은 객체다  , 동등객체인지 
		// 주소값 비교 -> 값 비교
		System.out.println("book1과 book2는 동일한 객체 인가요?"+ (book1 == book4));
		System.out.println("book1과 book2는 동등한 객체 인가요?"+ book1.equals(book4));
		
		//3. Object.hashCode()
		//오버라이드 전 : 주소값을 해싱한 값을 반환하는 메서드, 인스턴스를  식별할 수 있는 숫자값을 반환
		System.out.println("book1의 hashCode : " + book1.hashCode());
		System.out.println("book1의 hashCode : " + book4.hashCode());
	}
	
	

}
