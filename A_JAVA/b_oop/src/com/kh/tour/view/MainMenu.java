package com.kh.tour.view;

import java.util.Scanner;

import com.kh.tour.controller.TourController;

public class MainMenu {
	
	Scanner sc = new Scanner(System.in);
	private TourController tc = new TourController();
	
	{	
		//환영 문구
		System.out.println("***************KH항공사에 오신 고객님 환영합니다*************");
		
		
	}
	
	public MainMenu() {
		System.out.println("현재 보유 금액 : "+ tc.bringMyMoney() );
		System.out.println("현재 보유 마일리지 : "+ tc.bringMyMile() );
		
		boolean flg = true;
		while(flg) {
			System.out.println("번호    목적지       가격          마일리지");
			System.out.println("1   미국행   3000000   3000");
			System.out.println("2   중국행   2000000   2000");
			System.out.println("3   일본행   1500000   1500");
			System.out.print("목적지 선택(번호입력):" );
			int inputNum = sc.nextInt();
			
			switch(inputNum) {
			case 1 : 
				if(tc.isAble(inputNum)) {
					//구매가 가능한 경우 
					tc.buyTicket1();
					System.out.println("티케팅 후 잔액은 : "+tc.bringMyMoney());
					System.out.println("티케팅 후 마일리지 : "+tc.bringMyMile());										
				}else {
					//구매가 불가능한 경우
					System.out.println("현재 잔고로 티켓을 구매 할 수 없습니다");
					flg = false;
				}
			
			case 2:
				if(tc.isAble(inputNum)) {
					//구매가 가능한 경우 
					tc.buyTicket2();
					System.out.println("티케팅 후 잔액은 : "+tc.bringMyMoney());
					System.out.println("티케팅 후 마일리지 : "+tc.bringMyMile());										
				}else {
					//구매가 불가능한 경우
					System.out.println("현재 잔고로 티켓을 구매 할 수 없습니다");
					flg = false;
				}
			case 3:
				if(tc.isAble(inputNum)) {
					//구매가 가능한 경우 
					tc.buyTicket3();
					System.out.println("티케팅 후 잔액은 : "+tc.bringMyMoney());
					System.out.println("티케팅 후 마일리지 : "+tc.bringMyMile());										
				}else {
					//구매가 불가능한 경우
					System.out.println("현재 잔고로 티켓을 구매 할 수 없습니다");
					flg = false;
				}
			default :
				System.out.println("잘못된 번호를 입력하셨습니다.");
			break;		
			}
		}
	}
	
	public void mainMenu() {
		
		}
	}

