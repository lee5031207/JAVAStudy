package com.kh.a_runtimeException;

import java.util.Scanner;

public class RuntimeException {
	//예외(Exception) :
	//		Compile Exception : 자바 문법 상의 예외, 이클립스가 빨간 줄로 표시해주는 예외
	// 		Runtime Exception : 실행 상황에서 발생하는 예외(ex.NullPointer)
	
	//		Checked Exception : 코드로 대비가 불가능하기 때문에 , 예외처리를 강제하는 예외
	//		Unchecked Exception : 코드로 대비가 가능, 예외처리를 강제하지 않음
	
	//예외처리 방법
	// 1.조건문 : 조건문을 사용해 예외가 발생할 수 있는 상황을 미리 회피
	// 2.try-catch문 : try{ }으로 예외가 발생할 수 있는 코드를 감싸고,
	//				  catch{ }에는 예외사항이 발생할 경우 처리할 후속 조치를 작성
	// 3.try-catch-finally : finally{ }블록에 예외가 발생하는 발생하지 않든 반드시 실행
	Scanner sc = new Scanner(System.in);
	
	// 1.if문으로 예외처리
	public void arithEx() {
		//숫자를 0 으로 나눠  ArithmathException을 발생시키자		
		int ran = 0;
		double result;
		//사용자가 지정한 수를 0~3사이의 난수로 나누는 코드
		while(true) {
			//제수 : 나누는 수, 피제수 : 나누어지는수
			System.out.println("피제수를 하나 정수로 입력하시오 :");
			int inputNum = sc.nextInt();
			// 0~3사이의 핸덤한 수로 제구를 지정
			ran = (int)(Math.random()*4);
			
			if(ran != 0) {
				result = inputNum/ran;
				System.out.println(ran+"으로 나눈 결과 : " + result);
			}else{
				System.out.println("숫자는 0 으로 나눌 수 없습니다");
			}

			
		}
	}
	
	// 2. try-catch문으로 예외처리
	public void arithEx2() {
		//숫자를 0 으로 나눠  ArithmathException을 발생시키자		
		int ran = 0;
		double result;
		//사용자가 지정한 수를 0~3사이의 난수로 나누는 코드
		while(true) {
			//제수 : 나누는 수, 피제수 : 나누어지는수
			System.out.println("피제수를 하나 정수로 입력하시오 :");
			int inputNum = sc.nextInt();
			// 0~3사이의 핸덤한 수로 제구를 지정
			ran = (int)(Math.random()*4);
			
			try {
				//try블록에서 예외가 발생하면 즉시 catch{ }의 코드가 실행
				result = inputNum/ran;
				System.out.println(ran+"으로 나눈 결과 : " + result);
			}catch(ArithmeticException e) { //저거도 다 클래스다
				e.printStackTrace(); //printstackTrace는 맨날 오류뜨면 나오는거 
				System.out.println("숫자는 0 으로 나눌 수 없습니다.");
			} //발생할 수 있는 예외의 레퍼런스를 catch{ }에 작성
		}
	}
	
	// 3. try-catch-finally 예외처리
	public void arithEx3() {
		//숫자를 0 으로 나눠  ArithmathException을 발생시키자		
		int ran = 0;
		double result;
		//사용자가 지정한 수를 0~3사이의 난수로 나누는 코드
		while(true) {
			//제수 : 나누는 수, 피제수 : 나누어지는수
			System.out.println("피제수를 하나 정수로 입력하시오 :");
			int inputNum = sc.nextInt();
			// 0~3사이의 핸덤한 수로 제구를 지정
			ran = (int)(Math.random()*4);
			
			try {
				//try블록에서 예외가 발생하면 즉시 catch{ }의 코드가 실행
				result = inputNum/ran;
				System.out.println(ran+"으로 나눈 결과 : " + result);
			//발생할 수 있는 예외의 레퍼런스를 catch{ }에 작성
			}catch(ArithmeticException e) { //저거도 다 클래스다
				e.printStackTrace(); //printstackTrace는 맨날 오류뜨면 나오는거 
				System.out.println("숫자는 0 으로 나눌 수 없습니다.");
			}finally { //예외가 발생하든 말든 무조건 실행되는 블록
				System.out.println("finalBlock");
			}
		}
	}
	
	// 4.
	public void classNArrayEx() {
		try {
			//ClassCastException 상속문제
			Object obj = new Object();
			//String str = (String)obj;
			
			//ArrayIndexOutOfBoundsException //인덱스범위 벗어난 곳에 값넣어주는
			int[] arr = new int[2];
			//arr[2] = 3;
			
			//NullPointerException  //널값을 참조하려 할때
			String nullstr = null;
			nullstr.charAt(2);
		
			//자바 1.7 이전 코드
//		} catch (ClassCastException e) {
//			System.out.println(e.getMessage());
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
//		} catch (NullPointerException e) {
//			System.out.println(e.getMessage());
			
			//다형성을 활용
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		}catch (ClassCastException | ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println(e.getMessage());			
		}
			
		
		
	}
	
}
