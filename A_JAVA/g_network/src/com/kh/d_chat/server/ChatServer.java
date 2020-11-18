package com.kh.d_chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

	private ServerSocket server; //서버 소켓
	private List<Socket> sockerList;  //클라이언트의 소켓을 담아줄 리스트
	
	public ChatServer() {
		try {
			server = new ServerSocket(8989);
			sockerList = new ArrayList<Socket>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startServer() {
		System.out.println("채팅 서버를 시작합니다.");
		while(true){
			try {
				Socket client = server.accept();
				sockerList.add(client);
				System.out.println(">>접속 인원 : "+sockerList.size());
				read(client);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void read(Socket socket) {
		
		Thread thread = new Thread(new Runnable() {			
			@Override
			public void run() {
				BufferedReader br = null;
				try {
					br = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					while(true) {
						String data = br.readLine();
						if(data != null) {
							System.out.println(data);
							allClientWrite(data);
						}
					}
				}catch (IOException e) {					
					try {
						br.close();
						removeSocket(socket);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

	public void allClientWrite(String msg) {
		
		PrintWriter writer = null;
		for (Socket client : sockerList) {
			try {
				writer = new PrintWriter(client.getOutputStream());
				writer.println(msg);
				writer.flush();
			} catch (IOException e) {
				writer.close();
				removeSocket(client);
				e.printStackTrace();				
			}
		}
	}
	
	//SocketList에서 예외가 발생한 Socket 제거
	public void removeSocket(Socket socket) {
		System.out.println("socket is close");
		System.out.println("===============");
		System.out.println(">>접속 인원 : "+sockerList.size());
		try {
			sockerList.remove(socket);
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(">>접속 인원 : "+sockerList.size());
		System.out.println("===============");
	}
	
}
