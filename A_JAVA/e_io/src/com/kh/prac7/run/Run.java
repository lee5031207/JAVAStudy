package com.kh.prac7.run;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.kh.prac7.controller.SungjukProcess;

public class Run {
	public static void main(String[] args) {
		
		SungjukProcess sp = new SungjukProcess();
		sp.SungjukSave();
		sp.scoreRead();
	}
}
