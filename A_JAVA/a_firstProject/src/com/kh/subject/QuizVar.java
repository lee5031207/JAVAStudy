package com.kh.subject;

import java.util.*;

public class QuizVar {
	//이성욱_추석과제 오후반
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuizVar var = new QuizVar();
		var.example3();
	}
	public void example1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 정수:");
		int no1 = sc.nextInt();
		System.out.print("두 번째 정수:");
		int no2 = sc.nextInt();
		
		System.out.println("더하기 결과 : "+(no1+no2));
		System.out.println("빼기 결과 : "+(no1-no2));
		System.out.println("곱하기 결과 : "+(no1*no2));
		System.out.println("나누기 결과 : "+(no1/no2));
		System.out.println("나누기한 나머지 : "+(no1%no2));
	}
	public void example2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가로:");
		float width = sc.nextFloat();
		System.out.print("세로:");
		float height = sc.nextFloat();
		
		System.out.println("면적: "+ (width*height));
		System.out.println("둘레 : "+ 2*(width+height));
	}
	
	public void example3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열을 입력하시오 : ");
		String text = sc.nextLine();
		
		System.out.println("첫번째 문자 :"+ text.charAt(0));
		System.out.println("두번째 문자 :"+ text.charAt(1));
		System.out.println("세번째 문자 :"+ text.charAt(2));
	}
	
	
}
