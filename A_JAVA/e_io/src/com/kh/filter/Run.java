package com.kh.filter;

public class Run {

	public static void main(String[] args) {
		A_BufferedIO bio = new A_BufferedIO();
		//bio.bufferedWithFile();
		
		B_bufferedWR bwr = new B_bufferedWR();
		//bwr.bufferedWriter();
		
		C_ObjectIO oio = new C_ObjectIO();
		oio.objectInput();
		
		D_StreamWR swr = new D_StreamWR();
		//swr.readWithStream();
		
		C_ObjectIO2 oio2 = new C_ObjectIO2();
		//oio2.objectOutput();
		
		E_PrintWriter writer = new E_PrintWriter();
		//writer.printWriter();
	}

}
