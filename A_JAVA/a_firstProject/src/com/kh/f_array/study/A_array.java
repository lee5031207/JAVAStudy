package com.kh.f_array.study;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class A_array {
	
	Scanner sc = new Scanner(System.in);
	
	public void testArray() {
		//배열 : 같은 타입의 데이터들을 하나의 묶음으로 다루는 것
		//		각 데이터들은 해당 데이터에 접근할 수 있도록 인덱스 번호가 부여된다.
		//      배열은 참조자료형으로 heap영역에 저장된다.
		// 		참조형 변수(reference)를 통해 배열에 접근할 수 있고, 인덱스를 통해 배열 안의 데이터에 접근할 수 있다.
		
		//배열 생성해보기
		String[] sArr = new String[5]; //String 타입의 데이터 5개를 보관할 수 있는 배열 생성.
		sArr[0] = "치킨"; //0번 인덱스의 변수방에 치킨을 저장
		sArr[1] = "족발"; //1번 인덱스에 족발을 저장
		sArr[2] = "감자튀김"; //2번 인덱스에 감자튀김을 저장
		sArr[3] = "군고구마"; //3번 인덱스에 군고구마 저장
		sArr[4] = "탕수육"; //4번 인덱스에 탕수육 저장
		
		//저장한 데이터는 인덱스로 접근해 꺼내올 수 있다.
		System.out.println("sArr : " + sArr);
		System.out.println("sArr[3] : " + sArr[3]);
	}
	
	public void testArray2() {
		//배열을 사용하는 이유
		//타입이 같은 복수의 데이터를 편하게 다루기 위해.
		
		int sum = 0;
		int arrSum = 0;
		
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;

		//num1 ~ num5 의 합계를 sum에 저장
		sum += num1;
		sum += num2;
		sum += num3;
		sum += num4;
		sum += num5;
		
		System.out.println("num1~num5 까지의 합계 : " + sum);
		
		//배열을 사용한다면?
	
		/*
		 * int[] iArr = new int[5];
		 * iArr[0] = 10;
		 * iArr[1] = 20;
		 * iArr[2] = 30;
		 * iArr[3] = 40;
		 * iArr[4] = 50;
		 */
		 
		
		int[] iArr = {10,20,30,40,50};
		//Array.length : 배열의 크기를 가지고 있는 변수
		//System.out.println(iArr.length) -> 5 출력 
		for(int i = 0; i < iArr.length; i++) {
			arrSum += iArr[i];
		}
		
		System.out.println("iArr[0] ~ iArr[4] 까지의 합계 : " + arrSum);
	}
	
	public void testArray3() {
		
		//배열의 선언과 동시에 초기화
		int[] iArr = new int[] {5,4,3,2,1};
		for(int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i]);
		}
		
		System.out.println();
		
		//배열을 리터럴로 초기화.(String 처럼 특별대우를 받는 타입)
		int[] iArr2 = {1,2,3,4,5};
		for(int i = 0; i < iArr2.length; i++) {
			System.out.print(iArr2[i]);
		}
	}
	
	public void testArray4() {
		//배열의 크기는 변수로도 지정할 수 있다.
		int size = 10;
		int[] iArr = new int[size];
		
		//사용자로부터 배열의 크기를 입력받아서 배열을 생성
		System.out.print("배열의 크기 : ");
		int input = sc.nextInt();
		int[] iArr2 = new int[input];
		
		System.out.println("생성된 배열의 크기 : " + iArr2.length);
		
	}
	
	public void testArray5() {
		//얕은 복사
		String[] foodArr = {"치킨","족발","라면","돈가스","냉면"};
		
		//대입연산자는 stack영역에 있는 값을 넘겨준다 
		//즉,실제로 새로운 배열을 복사하는게 아니라 copyArr이 foodArr의 주소를 참조하는 형식의 얕은 복사가 일어난다
		String[] copyArr = foodArr; // stack 영역의 foodArr변수명에는 주소가 저장되어 있다.
		
		
		for(int i=0; i<foodArr.length;i++) {
			System.out.print(foodArr[i]+" ");		
		}		
		System.out.println();
		System.out.println(Arrays.toString(copyArr));
		
		System.out.println("==========================");
		//주소를 출력
		System.out.println("foodArr의 주소 : "+ System.identityHashCode(foodArr));
		System.out.println("copyArr의 주소 : "+ System.identityHashCode(copyArr));
		// 주소가 같은 이유는 대입 연산자로 주소가 넘어갔으니까
		System.out.println("==========================");
		foodArr[3] = "피자"; //foodArr값 변경
		
		System.out.println(Arrays.toString(copyArr));
		
	}
	public void testArray6() {
		//깊은 복사
		String[] foodArr = {"치킨","족발","라면","돈가스","냉면"};
		String[] copyArr = new String[foodArr.length];
		
		for(int i=0; i<foodArr.length; i++) {
			copyArr[i] = foodArr[i];
		}
		//주소를 출력
		System.out.println("foodArr의 주소 : "+ System.identityHashCode(foodArr));
		System.out.println("copyArr의 주소 : "+ System.identityHashCode(copyArr));
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
