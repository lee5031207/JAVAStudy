package com.kh.d_chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {

	private Socket socket;
	private String host;
	private int port;
	Scanner sc = new Scanner(System.in);
	
	public void chatStart() {
		connect();
		read();
		write();
	}
	
	public void connect() { //생성자
		
		System.out.println("서버 IP : ");
		host = sc.nextLine();
		System.out.println("서버 Port : ");
		port = sc.nextInt();
		
		try {
			socket = new Socket(host,port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void write() {
		sc.nextLine(); //버퍼 비우는 용도
		
		//닉네임 입력
		System.out.println("닉네임 >> ");
		String userId = sc.nextLine();
		
		
		while(true) {
			System.out.println("입력 >>");
			String msg = sc.nextLine();
			PrintWriter writer = null;
			try {
				writer = new PrintWriter(socket.getOutputStream());
				writer.println(userId + ":" + msg);
				writer.flush();
			} catch (IOException e) {
				try {
					writer.close();
					socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		}
	}
	
	public void read() {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				BufferedReader br = null;
				
				while(true) {
					try {
						br = new BufferedReader(
								new InputStreamReader(
										socket.getInputStream()));
						String data = br.readLine();
						if(data != null) {
							System.out.println("\n"+data);
						}
					} catch (IOException e) {
						try {
							br.close();
							socket.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						e.printStackTrace();
					}
				}
			}
		});
		
		thread.start();
	}
	
}
