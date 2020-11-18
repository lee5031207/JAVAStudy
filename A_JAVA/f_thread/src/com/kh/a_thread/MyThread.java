package com.kh.a_thread;

public class MyThread extends Thread{

	//프로세스 : 실행중인 프로그램을 의미, 자원(시스템자원)과 쓰레드(작업) 으로 구성
	//쓰레드 : 프로세스 내에서 실제 수행되는 작업의 한 단위
	
	
	//Thread(쓰레드) 생성하기
	//1. Thread 클래스 상속 받기
	//2. Runnable 인터페이스 구현 
	//   -> Thread의 생성자 매개변수로 Runnable 인스턴스 
	
	//새롭게 시작될 쓰래드의 Main 메서드 역할을 하는 메서드 run
	//스레드를 상속받으면 반드시 오버라이드 해야댐
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(i+" : "+getName());
		}
	}
}
