package com.kh.f_demensionArray;

import java.util.Scanner;

public class DemensionArrayPrac {
	
	Scanner sc = new Scanner(System.in);

	//사용자에게 정수값을 하나 입력받아
	//주소배열의 크기와 배열의 크기가 사용자가 입력한 값을 가지는
	//2차원 배열을 생성하시오
	//2차원 배열에 숫자를 1부터 순차적으로 입력하되
	//주소배열의 인덱스가 짝수일때는 왼쪽에서 오른쪽으로
	//주소배열의 인덱스가 홀수일때는 오른쪽에서 왼쪽으로 입력되도록 하시오
	//ex) 사용자가 입력한 값 3
	// int[][] doubleArr = new int[3][3];
	// 1 2 3
	// 6 5 4
	// 7 8 9
	public void quize() {
		//사용자에게 정수 하나 입력받기
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		//2차원배열 생성
		int[][] doubleArr = new int[input][input];
		
		//2차원 배열 초기화
		//1부터 순차적으로 증가할 정수형 변수 1개 선언
		int num = 1;
		for(int i = 0; i < doubleArr.length; i++) {
			if(i % 2 == 0) {
				//주소배열의 인덱스가 짝수 일때는
				//작은 인덱스에서 큰 인덱스 순으로 배열을 초기화
				for(int j = 0; j < doubleArr[i].length; j++) {
					doubleArr[i][j] = num++;
				}
			}else {
				//주소배열의 인덱스가 홀수 일때는 
				//배열의 초기화를 큰 인덱스에서 작은 인덱스 순으로 초기화
				for(int j = doubleArr[i].length - 1; j >= 0; j--) {
					doubleArr[i][j] = num++;
				}
			}
		}
		
		//2차원 배열을 출력
		for(int i = 0; i < doubleArr.length; i++) {
			for(int j = 0; j < doubleArr[i].length; j++) {
				System.out.printf("%5d",doubleArr[i][j]);
			}
			System.out.println();
		}
	}
	
	//2차원 배열을 활용한 좌표찍기
	//크기가 5인 char배열을 5개 가지는 2차원 배열을 생성하세요.
	//사용자로부터 행 인덱스와 열 인덱스를 입력 받으세요.
	//2차원 배열을 활용해 좌표를 그리고
	//사용자가 입력한 행,열 에 좌표를  X 로 찍어주세요.
	//사용자가 행인덱스 또는 열인덱스에 배열의 크기를 벗어나는 숫자를 입력하면
	//'프로그램을 종료합니다' 출력하고 프로그램을 종료하세요.
	public void quize2() {
		char[][] charArray = new char[5][5];		
		
		System.out.println("    0  1  2  3  4");
		for(int i=0; i<5; i++) {
			System.out.print(i+"   ");
			for(int j=0; j<5; j++) {
				charArray[i][j] = 'o';
				System.out.print(charArray[i][j]+"  ");
			}
			System.out.println("");
		}
		
		while(true) {
			System.out.print("행 인덱스 입력 >> ");
			int row = sc.nextInt();
			System.out.print("열 인덱스 입력 >> ");
			int column = sc.nextInt();
			if((row>=0 && row<5)&&(column>=0 && column<5)) {
				charArray[row][column] = 'x';
				//출력 부분
				System.out.println("    0  1  2  3  4");
				for(int i=0; i<5; i++) {
					System.out.print(i+"   ");
					for(int j=0; j<5; j++) {						
						System.out.print(charArray[i][j]+"  ");
					}
					System.out.println("");
				}
			}else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}				
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
