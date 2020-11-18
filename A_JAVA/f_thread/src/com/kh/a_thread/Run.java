package com.kh.a_thread;

public class Run {

	public static void main(String[] args) {
		//메인 쓰레드 이름 찍어보기
		System.out.println("메인메서드가 동작하고 있는 Thread : "
				+ Thread.currentThread().getName());
		
		MyThread m1 = new MyThread();
		//Thread 이름 지정
		m1.setName("MyfirstThread");
		//Thread 실행
		m1.start();
		
		System.out.println("====================");
		System.out.println("Main method의 마지막 코드");
		System.out.println("====================");
		
		//프로그램은 모든 쓰레드가 종료되면 종료된다.
		
		
		
		
	}
}
