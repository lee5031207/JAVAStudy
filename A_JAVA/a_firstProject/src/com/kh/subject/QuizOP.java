package com.kh.subject;

import java.util.*;

public class QuizOP {
	//이성욱_추석과제 오후반
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuizOP op = new QuizOP();
		
	}
	public void sample1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int korean =sc.nextInt();
		System.out.print("영어 : ");
		int english =sc.nextInt();
		System.out.print("수학 : ");
		int math =sc.nextInt();
		
		int score = korean+english+math;
		float avg = score/3;
		System.out.println("총합 :"+score+"  평균 :"+avg);
		
		if((korean>=40)&&(english>=40)&&(math>=40)&&(avg>=60)) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
	}
	public void sample2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생이름 : ");
		String name = sc.nextLine();
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int class_no = sc.nextInt();
		System.out.print("번호 : ");
		int no = sc.nextInt();
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		System.out.print("성적: ");
		float score = sc.nextFloat();
		
		String sex = new String();
		if(gender == 'M') {
			sex = "남학생";
		}else if(gender == 'F'){
			sex = "여학생";
		}
		System.out.printf("%d학년 %d반 %d번 %s %s은 성적이 %.2f점이다.",grade,class_no,no,sex,name,score);
		
	}
	public void sample3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int no = sc.nextInt();
		if(no>0) {
			System.out.println("양수다");
		}else if(no<0) {
			System.out.println("양수가 아니다");
		}
	}
	
	public void sample4() {
		Scanner sc = new Scanner(System.in);
		
		int no;
		String text = new String();
		
		System.out.print("정수 입력 : ");
		no = sc.nextInt();
		if(no%2==0) {
			text = "짝수다";
			System.out.println(text);
		}else {
			text = "홀수다";
			System.out.println(text);
		}
	}



}
