package com.kh.c_prac.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.kh.c_prac.model.vo.Music;

public class TCPServer {

	
	public void serverStart() {
		//1. 서버의 포트번호 지정
		int port = 8080;
		
		//2. 서버 소켓 및 기타 스트림 레퍼런스 선언(null로)
		ServerSocket serverSocket = null;
		Socket client = null;
		PrintWriter writer = null;
		ObjectInputStream oInput = null;
		
		try {
			//3. 서버소켓  생성
			serverSocket = new ServerSocket(port);

			//4. 클라이언트로부터 접속 요청이 올 때 까지 대기
			System.out.println("클라이언트의 접속 요청을 대기중입니다.");
			
			//5. 접속 요청이 오면 요청 수락 후 클라이언트에 대한 소켓을 생성			
			client = serverSocket.accept();
			
			//6. 연결한 클라이언트의 IP정보를 출력
			System.out.println("클라이언트 IP정보 :"+ client.getLocalAddress().getHostAddress());
			
			//7. 연결된 클라이언트와 입출력 스트림 생성
			InputStream input = client.getInputStream();
			OutputStream output = client.getOutputStream();
			writer = new PrintWriter(output);
			
			//8. 클라이언트로 부터 전송된 객체를 읽어서 출력
			//   hint : 객체를 읽고 쓸 때는 ObjectInputStream,ObjectOutputStream
			oInput = new ObjectInputStream(input);
			Music res = (Music)oInput.readObject();
			System.out.println(res.toString());
			
			//9. 클라이언트에게 'exit' 메시지를 전송
			writer.println("exit");
			writer.flush();

			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				//10. 통신 종료(스트림 및 소켓 close)
				serverSocket.close();
				client.close();
				writer.close();
				oInput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
