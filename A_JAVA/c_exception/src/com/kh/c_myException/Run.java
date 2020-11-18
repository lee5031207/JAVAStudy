package com.kh.c_myException;

public class Run {

	//throw : 예외를 발생시키는 예약어
	//throws : 예외를 호출한 클래스로 던지는 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Run run = new Run();
		
		//UnchecckedException은 예외처리를 강제하지 않는다.
		run.checkScore(93);
		
		
		//checkedException 은 예외처리를 강제한다.
		try {
			run.checkGrade('Z');
		} catch (MyCheckedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
	
	private void checkScore(int score) {
		if(score>=0 && score<100) {
			System.out.println("당신의 점수는 : " + score + "입니다.");			
		}else {
			throw new MyUncheckedException("score의 값이 적절하지 않습니다.");			
		}
	}
	
	private void checkGrade(char grade) throws MyCheckedException {
		if(grade >= 'A' && grade <= 'F'){
			System.out.println("당신의 등급은 : " + grade + "입니다.");		
		}else {
			throw new MyCheckedException("존재하지 않는 등급입니다.");
		}
	}

}
