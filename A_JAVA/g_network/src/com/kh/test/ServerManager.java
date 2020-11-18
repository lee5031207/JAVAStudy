package com.kh.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerManager {

	public ServerManager() {
		
	}

	public void serverStart() {

		// 1. port 번호 지정
		int port = 4000;
	
		// 2. 서버용 소켓 객체 생성
		ServerSocket server = null;
		Socket client = null;
		try {
			server = new ServerSocket(port);
		// 3. 클라이언트가 연결을 요청할 때까지 기다림
			while (true) {
		// 4. 연결을 요청한 클라이언트의 요청 수락함 : 해당 클라이언트 정보를 저장
					client = server.accept();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				server.close();
				client.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
