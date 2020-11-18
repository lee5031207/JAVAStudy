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

public class QRCodeMakerFor {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("QR코드 몇장을 생성하시겠습니까 ?");
		int cnt = sc.nextInt();
		String[] urlArr = new String[cnt];
		String[] fileNameArr = new String[cnt];
		
		for(int i=0; i<cnt; i++) {
			Scanner forsc = new Scanner(System.in);
			System.out.print("QR코드로 제작할 주소를 입력 : "); 
			urlArr[i] = forsc.nextLine();  
			System.out.print("파일명 : ");  
			fileNameArr[i] = forsc.nextLine(); 
			
			try {
				BitMatrix bm = new QRCodeWriter().encode(urlArr[i], BarcodeFormat.QR_CODE, 300, 300);
				MatrixToImageWriter.writeToStream(bm, "png", new FileOutputStream(fileNameArr[i]+".png"));
				System.out.println(fileNameArr[i]+".png 파일을 생성했습니다.");
				
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
		}
	}
}
	

