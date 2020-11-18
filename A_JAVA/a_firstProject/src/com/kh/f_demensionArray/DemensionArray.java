package com.kh.f_demensionArray;

public class DemensionArray {
	
	public void testDemensionArray() {
		//2차원 배열은 배열을 여러개 가지고 있는 배열의 배열이다.
		//2차원 배열 선언
		int[][] doubleArr;
		
		//가능하지만 권하지 않음
		//int[] doubleArr1[]; //권장하지 않음
		int doubleArr2[][]; //권장하지 않음
		
		//2차원 배열의 메모리 할당 : new연산자를 사용해 heap 영역에 메모리를 확보한다.
		doubleArr = new int[3][4];
		//주소 배열의 크기는 3
		//데이터를 보관할 int[]의 크기는 4
		//quize! : 이때 heap영역에 생성되는 배열의 개수는 ? 
		//정답 : 4개 -> 배열의 주소를 저장할 배열 1개, int[] 3개
		
		//2차원배열 초기화
		//주소배열의 0번 인덱스에 참조되어있는
		//int[]의 0번 인덱스에 값을 1 넣음
		doubleArr[0][0] = 1;
		doubleArr[0][1] = 2;
		doubleArr[0][2] = 3;
		doubleArr[0][3] = 4;
		
		//주소배열의 1번 인덱스에 참조되어있는
		//int[]의 0번 인덱스에 값을 5 넣음
		doubleArr[1][0] = 5;
		doubleArr[1][1] = 6;
		doubleArr[1][2] = 7;
		doubleArr[1][3] = 8;
		
		//주소배열의 2번 인덱스에 참조되어있는
		//int[]의 0번 인덱스에 값을 9 넣음
		doubleArr[2][0] = 9;
		doubleArr[2][1] = 10;
		doubleArr[2][2] = 11;
		doubleArr[2][3] = 12;
		
		//2차원 배열의 주소 및 값 출력
		System.out.println("doublArr 변수에 담겨 있는 주소값 : " + doubleArr);
		System.out.println("주소배열의 0번째 인덱스에 담겨있는 주소값 : " + doubleArr[0]);
		System.out.println("주소배열의 1번째 인덱스에 담겨있는 주소값 : " + doubleArr[1]);
		System.out.println("주소배열의 2번째 인덱스에 담겨있는 주소값 : " + doubleArr[2]);
		System.out.println("주소배열의 0번째 인덱스로 참조되는 배열의 0번째 인덱스의 값 : " + doubleArr[0][0]);
	
		//반복문을 활용한 2차원배열 출력
		for(int i=0; i < doubleArr.length; i++) {
			for(int j = 0; j < doubleArr[i].length; j++) {
				System.out.print(doubleArr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void testDemensionArray2() {
		//가변 배열
		//주소배열의 크기는 지정하지만 값을 저장할 배열의 크기는 지정하지 않는 것.
		int[][] doubleArr = new int[2][];
		doubleArr[0] = new int[3]; //주소배열의 0번 인덱스에 크기가 3인 배열의 주소를 저장
		doubleArr[1] = new int[2]; //주소배열의 1번 인덱스에 크기가 2인 배열의 주소를 저장
		
		//for문으로 2차원 배열 초기화하기
		int data = 1;
		//주소배열의 크기만큼 반복한다.
		for(int i = 0; i < doubleArr.length; i++) {
			//주소배열의 인덱스를 통해 접근하게 되는 값을 저장하는 배열의 크기만큼 반복한다.
			for(int j = 0; j < doubleArr[i].length; j++) {
				//주소배열의 인덱스를 통해 접근하는 배열에 값을 넣는다.
				doubleArr[i][j] = data++;
			}
		}
		
		//2차원배열 출력
		for(int i = 0; i < doubleArr.length; i++) {
			System.out.println("주소배열 " + i + "번 인덱스에 있는 배열");
			for(int j = 0; j < doubleArr[i].length; j++) {
				System.out.print(doubleArr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
