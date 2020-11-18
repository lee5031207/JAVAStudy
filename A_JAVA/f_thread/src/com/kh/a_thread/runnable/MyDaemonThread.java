package com.kh.a_thread.runnable;

public class MyDaemonThread implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<10; i++) {             //쓰레드의 이름
			System.out.println(i+"."+Thread.currentThread().getName()
											  //데몬쓰레드 여부
					+": 데몬스레드? : " + Thread.currentThread().isDaemon());
		}
		
	}
}
