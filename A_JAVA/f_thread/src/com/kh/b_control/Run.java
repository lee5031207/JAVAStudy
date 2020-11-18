package com.kh.b_control;

public class Run {
	
	//Thread 상태
	// 실횅, 실행 대기, 일시정지 , 중지
	// 실행(Running) : 실행되고 있는 상태
	// 실행대기(Runnable) : 실행될 수 있지만 아직 스케쥴링이 되지 않아서 실행을 기다리고 있는 상태
	// 일시정지 : 쓰레드를 실행할 수 없는 상태
	// 1)waiting : wait(), join(), sleep() 메서드에 의해 멈춰진 상태
	// 2)timed waiting: wait(miliseconds), join(miliseconds), sleep(miliseconds)
	//	 지정된 시간동안 쓰레드가 일시정지 되었다가, 시간이 지나고 나면 다시 실행대기가 되는 상태
	// 3)BLOCKED : 사용하고자 하는 객체가 LOCK에 걸려 대기하는 경우
	//	 중지 : 모든 코드를 실행하고 쓰레드가 중지된 상태
	
	//Thread를 제어하는 메서드
	//start() : 쓰레드를 실행 대기 상태로 만들어 준다
	//yield() : 실행 중인 쓰레드를 실행대기로 만들어 준다.
	//Object.notify() : wait()메서드에 의해 일시정지 상태인 쓰레드를 실행대기로 변경
	
	
	public static void main(String[] args) {
		
	}
}
