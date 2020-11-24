package com.car;

public interface Temp {
	int TEMP = 0;
	int getTempGage();
	default void info() {
		System.out.println(TEMP);
	}
}
