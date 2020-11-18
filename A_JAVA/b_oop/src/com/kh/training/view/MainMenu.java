package com.kh.training.view;

import java.util.Scanner;

import com.kh.training.controller.TrainingManager;
import com.kh.training.model.vo.Trainee;

public class MainMenu {

	Scanner sc = new Scanner(System.in);
	
	
	
	public void mainMenu() {
		//관리할 훈련생 숫자 입력 받아 TrainingManager 객체 생성
		System.out.print("관리할 훈련생 수를 입력하시오 :");
		int trCnt = sc.nextInt();
		TrainingManager tm = new TrainingManager(trCnt);
			while(true){
				System.out.println("====== 메뉴 ======");
				System.out.println("1. 훈련생 추가");
				System.out.println("2. 훈련생 전체 조회");
				System.out.println("3. 훈련생 이름으로 검색");
				System.out.println("9. 프로그램 종료");
				// 사용자의 입력에 따라 TrainingManager의 메소드 호출
				//또는 프로그램 종료
				int no = sc.nextInt();
				switch(no) {
				case 1: tm.insertTrainees();break;
				case 2: tm.printTrainees();break;
				case 3: tm.searchTraunees();break;
				case 9: break;
				}
			}
		}
}
