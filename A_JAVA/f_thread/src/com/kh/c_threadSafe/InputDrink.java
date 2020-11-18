package com.kh.c_threadSafe;

public class InputDrink extends Thread{

	//필드변수 heap 영역(Thread가 공유하는)에 저장된다.
	private String drink;
	
	public synchronized String input(String drink) {
		this.drink = drink;
		System.out.println("InputDrink : 물병에  "+ drink +" 채운다. ");
		return drink;
		 
	}
}
