package com.kh.test;

import java.io.Serializable;

public class Food  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6090562229242018546L;
	
	private String name;
	private int kcal;
	
	public Food() {
		
	}
	
	public Food(String name, int kcal) {
		super();
		this.name = name;
		this.kcal = kcal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", kcal=" + kcal + "]";
	}
}
