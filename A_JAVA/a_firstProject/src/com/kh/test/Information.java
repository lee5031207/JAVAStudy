package com.kh.test;
import java.util.Scanner;

public class Information {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] q = {"클러스터","DBMS_OUTPUT","옵티마이저","WSDL","UDDI","배치프로그램","REST","SSL/TLS","리치 클라이언트","프로시저","사용자 정의 함수","트리거","스키마","DoS","DDoS",
				"SYN FLOODING","스머프","스니핑","ping of Death","TearDrop", "XSS", "NoSQL", "빅 데이터","데이터 웨어 하우스","로킹","스레싱","에이징","RUDY","DRM","시큐어코딩",
				"DBMS","라우팅 알고리즘"
		};
		
		Scanner sc = new Scanner(System.in);
		
		int[] a = new int[q.length];
		
		while(true) {
			System.out.print("문제를 푸시겠습니까 y/n : ");
			 char answer = sc.next().charAt(0);			 
			 if(answer == 'y') {				
				 int i = (int) (Math.random()*q.length);
				 if(a[i] == 0) {
					 System.out.println(q[i]);
					 a[i] = i;
					 
				 }else if(a[i] != 0){
					 continue;
				 }
				 
			 }else {
				 break;
			 }
	
		}
	}

}
