package com.kh.a_thread.runnable;

public class Run {
	public static void main(String[] args) {
	
		Thread m1 = new Thread(new MyThread());
		m1.setName("m1");
		Thread m2 = new Thread(new MyDaemonThread());
		m2.setName("m2");
		m2.setDaemon(true);
		
		m1.start();
		m2.start();
		
		System.out.println("////////////////////////");
		System.out.println("뭐냐이건");
		System.out.println("////////////////////////");
		
	
	}
}
