package com.kh.a_thread.runnable;

//Runnable 인터페이스 구현을 통한 쓰레드 생성
public class MyThread implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<10; i++) {             //쓰레드의 이름
			System.out.println(i+"."+Thread.currentThread().getName()
											  //데몬쓰레드 여부
					+": 데몬스레드? : " + Thread.currentThread().isDaemon());
		}
		
	}

}
