package com.kh.c_threadSafe;

public class Run {

	public static void main(String[] args) {
		
		InputDrink id = new InputDrink();
		CoffeeThread coffee = new CoffeeThread(id);
		SoiThread soi = new SoiThread(id);
		
		coffee.setName("coffee Boy");
		soi.setName("soi Girl");
		
		coffee.start();
		soi.start();
	}
}
