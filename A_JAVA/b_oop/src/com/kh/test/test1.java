package com.kh.test;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1~100 사이의 정수를 입력하시오");
		int num = sc.nextInt();
		
		if(num>=1 && num <=100) {  
			if(num == 1) {
				System.out.println("1은 소수가  아닙니다");
			}else {
				for(int i=2; i< num; i++) {
					if(num%i == 0 ) {
						System.out.println(num + "은 소수가 아닙니다.");
						break;
					}else {
						System.out.println(num + "은 소수입니다.");
						break;
					}
				}				
			}
		}else {
			System.out.println("1부터 100 사이의 정수를 입력하세요!");
		}
	}
}
