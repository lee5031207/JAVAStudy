package com.kh.h_interface;

public class Run {

	public static void main(String[] args) {
		
		BatteryDetachable smartphone
		= new SmartPhone("애플", "iphoneX", 120, "ios", 9, "KT");
		
		//오버라이드한 메서드
		smartphone.attachBattery();		
		smartphone.detachBattery();
		
		//인터페이스의  default메서드
		smartphone.info();
		
	}
}
