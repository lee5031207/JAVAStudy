package com.kh.training.controller;

import java.util.Scanner;

import com.kh.training.model.vo.Trainee;

public class TrainingManager {

	private Trainee[] trainees;
	
	private static int CUTLINE = 60;
	
	Scanner sc = new Scanner(System.in);
	
	public TrainingManager() {
		
	}
	
	public TrainingManager (int num) {
		 trainees = new Trainee[num];
	}
	
	public void insertTrainees() {
		System.out.println("===훈련생 정보 입력 ===");
		for(int i=0; i<trainees.length; i++) {
			System.out.println("===="+(i+1)+"번째 학생====");
			System.out.print("훈련생 이름을 입력하시오 : ");			
			String name = sc.next();
			System.out.print("훈련생 반을 입력하시오 : ");
			char classRoom = sc.next().charAt(0);		
			System.out.print("훈련생 점수를 입력하시오 : ");
			int score = sc.nextInt();			
			trainees[i] = new Trainee(name, classRoom, score);
		}
		//System.out.println(trainees.length);
		System.out.println("===입력 완료===");
	}
	
	public int sumScore() {
		int result = 0;
		for(Trainee trainee : trainees) {
			result += trainee.getScore();
		}
		return result;
	}
	
	public double avgScore() {
		double result = sumScore()/trainees.length;		
		return result;
	}
	
	public String passFail(int i) {
		if(trainees[i].getScore()>=CUTLINE) {
			return "Pass";
		}else {
			return "Fail";
		}
	}
	
	public void printTrainees() {
		System.out.println("===훈련생 전체 정보 출력===");
		System.out.println("점수 합계 : "+sumScore());
		System.out.println("점수 평균 : "+avgScore());
		
		for(int i=0; i<trainees.length; i++) {
			System.out.println(trainees[i].inform() + " 결과는 " + passFail(i) +" 입니다");			
		}
	}
	
	public void searchTraunees() {
		System.out.print("검색할 사람의 이름 : ");
		String searchName = sc.next();
		int cnt = 0;
		for(int i=0; i<trainees.length; i++) {
			if(trainees[i].getName().equals(searchName)) {
				System.out.println(trainees[i].inform() + " 결과는 " + passFail(i) +" 입니다");
				cnt++;
			}
			if(cnt==0) {
				System.out.println("검색한 훈련생이 존재하지 않습니다.");
			}
		}
	}
	
	
	
	
	
}
