package com.kh.qrcode.maker;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeMakerWhile {

	public static void main(String[] args) {
		
		boolean myBool = true;
		
		while(myBool) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("QR코드를 생성하시겠습니까?");
			System.out.println("QR코드생성(1) or 프로그램 종료(0)");
			int res = sc.nextInt();
			
			if(res == 1) {
				Scanner whilesc = new Scanner(System.in);
				System.out.print("QR코드로 제작할 주소를 입력 : ");
				String url = whilesc.nextLine();
				System.out.print("파일명 : ");
				String fileName = whilesc.nextLine();
								
				try {
					BitMatrix bm = new QRCodeWriter().encode(url, BarcodeFormat.QR_CODE,300,300);
					MatrixToImageWriter.writeToStream(bm, "png", new FileOutputStream(fileName+".png"));
				} catch (WriterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
								
			}else if(res == 0) {
				System.out.println("프로그램을 종료합니다");
				myBool = false;				
			}else {
				System.out.println("잘못입력하셨습니다");
			}
		}
		
	}
}
