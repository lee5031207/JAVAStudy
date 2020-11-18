package com.kh.test.product.controller;

import com.kh.test.product.model.vo.Computer;
import com.kh.test.product.model.vo.Sugar;

public class KHFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Computer[] c = new Computer[3];
		c[0] = new Computer(123456, 1, "KH컴퓨터");
		c[1] = new Computer(112233, 1, "KH컴퓨터");
		c[2] = new Computer(111333, 1, "KH컴퓨터");
		
		for(Computer computer : c) {
			computer.makeProduct();
		}
		
		System.out.println();
		
		Sugar[] s = new Sugar[2];
		s[0] = new Sugar("흑설탕", 5, 2, "KH설탕");
		s[1] = new Sugar("백설탕", 2, 2, "KH설탕");
		
		for(Sugar sugar : s) {
			sugar.makeProduct();
		}
				
	}

}
