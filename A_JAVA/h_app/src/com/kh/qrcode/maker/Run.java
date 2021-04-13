package com.kh.qrcode.maker;

public class Run {

	public static void main(String[] args) {
		new QRCodeMaker().makeQR("http://61.74.127.111:9090/index", "index");
		
	}
}
