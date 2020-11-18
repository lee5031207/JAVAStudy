package com.kh.subject;

import java.util.*;

public class QuizCasting {
	//이성욱_추석과제 오후반
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuizCasting cas = new QuizCasting();
		
	}
	public void printUniCode() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자 입력 : ");
		char text = sc.next().charAt(0);
		
		System.out.printf("%s is unicode : %d", text, (int)text);
	}
	
	public void calculatorScore() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		float korean = sc.nextFloat();
		System.out.print("영어 : ");
		float english = sc.nextFloat();
		System.out.print("수학 : ");
		float math = sc.nextFloat();
		
		System.out.println("총점 :"+(int)(korean+english+math));
		System.out.println("총점 :"+(int)(korean+english+math)/3);
	}
}
