package com.kh.qrcode.maker;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeColorMaker {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("QR코드로 제작할 주소를 입력 : ");
		String url = sc.nextLine();
		System.out.print("파일명 : ");
		String fileName = sc.nextLine();
		System.out.println("원하는 색상의 ARGB코드 입력 :");
		int color = sc.nextInt();
		
		try {
			MatrixToImageConfig myConfig = new MatrixToImageConfig(color, -1);
			BitMatrix bm = new QRCodeWriter().encode(url, BarcodeFormat.QR_CODE,300,300);
			MatrixToImageWriter.writeToStream(bm, "png", new FileOutputStream(fileName+".png"), myConfig);

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
