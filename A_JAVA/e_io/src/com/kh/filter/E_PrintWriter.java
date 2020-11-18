package com.kh.filter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class E_PrintWriter {

	
	Scanner sc = new Scanner(System.in);
	
	public void printWriter() {
	
		System.out.print("파일명을 작성하세요 : ");
		String fileName = sc.nextLine();
		System.out.print("문구 작성하세요 : ");
		String contents = sc.nextLine();
		
		try(PrintWriter writer 
				= new PrintWriter(new FileOutputStream(fileName))) {
			writer.println(contents);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
