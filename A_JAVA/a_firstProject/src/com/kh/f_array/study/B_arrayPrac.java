package com.kh.f_array.study;

import java.util.Arrays;
import java.util.Random;

public class B_arrayPrac {

	ArrayUtil util = new ArrayUtil();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test2();
		
		
	}
	public static void test2() {
		int a[] = new int[10];
		int b[] = new int[10];
		int c[] = new int[10];
		
		for(int i=0; i<a.length; i++) {
			a[i]=(int)(Math.random()*95)+1;
			b[i]=(int)(Math.random()*95)+1;
			c[i]=(int)(Math.random()*95)+1;
		}
		int j=0;
		int temp=0;
	
		ArrayUtil util = new ArrayUtil();
		
		int aplusb[] = util.addAll(a, b);
		int result[] = util.addAll(aplusb, c);
		
		System.out.println("정렬전 : "+Arrays.toString(result));
		System.out.println("");
		
		result = util.sort(result);
		
		System.out.println("정렬후 : "+Arrays.toString(result));
		System.out.println("");
		
		System.out.println("7번째 : " + result[6]);
		System.out.println("8번째 : " + result[7]);
		System.out.println("9번째 : " + result[8]);
		
	}
	
	

}
