package com.kh.test;

import com.kh.test.product.model.vo.Product;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Product[] p = new Product[4];
		
		for(int i=0; i<p.length; i++) {
			p[i] = new Product("2", 5000);
			System.out.println(p[i].getPrice());
		}
	}

}
