package com.kh.test.shape.model.vo;

import java.math.*;

public class Circle {

	public static final double PI = Math.PI;
	private int radius;
	
	public Circle() {
		
	}

	public Circle(int radius) {
		this.radius = radius;
	}
	
	public void draw() {
		System.out.println("반지름 "+radius+"cm인 원을 그립니다");
	}
	
}
