package com.kh.filter;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//InputStreamReader : InputStream -> Reader
//OutputStreamWriter : OupputStream -> Writer
public class D_StreamWR {

	Scanner sc = new Scanner(System.in);
	
	public void writerWithStream() {
		System.out.print("파일명을 작성하세요 : ");
		String fileName = sc.nextLine();
		System.out.print("문구 작성하세요 : ");
		String contents = sc.nextLine();
		
		//outputStreamWriter을 사용해 
		//사용자가 입력한 파일경로에 있는 파일에 사용자가 입력한 문구를 출력하세요
		
		try(OutputStreamWriter osw
				= new OutputStreamWriter(new FileOutputStream(fileName))){
			osw.write(contents);
			osw.flush();
			System.out.println("파일을 작성했습니다");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readWithStream() {
		
		System.out.print("읽어올 파일명을 작성하세여 : ");
		String fileName = sc.nextLine();
		
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName))){
			
			int check = 0;
			String res = "";
			
			while((check = isr.read()) != -1) {
				res += (char)check;
			}
			
			System.out.println(res);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
