package com.kh.c_prac.client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.kh.c_prac.model.vo.Music;

public class TCPClient {

	
	public void clientStart() {
		
		//1.서버의 IP와 Port를 가지고 있는 변수 선언
		int port = 8080;
		String IP = "172.30.1.14";
		
		//2.Socket 및 스트림 변수 선언(Null로)
		Socket socket = null;
		BufferedReader reader = null;
		PrintWriter writer = null;
		
		try {
			//3.서버의 IP와 Port로 통신할 Socket 생성
			socket = new Socket(IP, port);
			
			
			if(socket != null) {
				//4.연결에 성공하면 서버와의 입출력 스트림 생성
				InputStream input = socket.getInputStream();
				OutputStream output = socket.getOutputStream();
				writer = new PrintWriter(output);
				reader = new BufferedReader(new InputStreamReader(input));
				
				//5.music.dat 파일을 읽어서 서버로 전송
				//   hint : 객체를 읽고 쓸때는  ObjectInputStream,ObjectOutputStream
				ObjectInputStream oInput = new ObjectInputStream(new FileInputStream("music.dat"));
				Music res = (Music)oInput.readObject(); //뮤직으로 변경해서 보내기
				//Object res = mois.readObject(); //Object형으로 보내기
				ObjectOutputStream oOutput = new ObjectOutputStream(output);
				oOutput.writeObject(res);
				oOutput.flush();			
							
				//6.서버로 부터 끝났다는 메시지(exit)가 돌아오면 통신을 종료
				if(reader.readLine().equals("exit")) {
					System.out.println("서버에서 exit 신호 도착, 통신을 종료합니다.");
				}
			}else {
				System.out.println("연결에 실패했습니다");
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//7.각종 스트림을 반환하고 socket을 닫아준다.
				socket.close();
				reader.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
		
	}
}
