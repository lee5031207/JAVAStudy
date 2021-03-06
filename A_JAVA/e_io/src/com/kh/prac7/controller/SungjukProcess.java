package com.kh.prac7.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SungjukProcess {

	Scanner sc = new Scanner(System.in);
	
	public SungjukProcess() {
		//기본 생성자
	}
	
	public void SungjukSave() {
		int num = 0;
		//학생 별로 국어, 영어, 수학 성적을 입력하면 총합과 평균을 파일에 저장하는 메서드	
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("score.dat"));
			
			loopOut:
			while(true) {
				System.out.println("=====다음의 성적을 입력하시오=====");
				System.out.print("국어 : ");
				int korean = sc.nextInt();
				dos.writeInt(korean); //국어 점수 write
				
				System.out.print("영어 : ");
				int english = sc.nextInt();
				dos.writeInt(english); //영어 점수 write
				
				System.out.print("수학 : ");
				int math = sc.nextInt();
				dos.writeInt(math); //수학 점수 write
				
				int sum = korean+english+math;
				dos.writeInt(sum); //점수 총합 write
				
				double avg = sum/3;
				dos.writeDouble(avg); //평균 점수 write
				
				sc.nextLine();
				
				num++;
				String answer = "";
				
				
				while(true) {
					
					Scanner sc= new Scanner(System.in);
					System.out.print("계속 저장하시겠습니까 ? (y/n) : ");
					answer = sc.nextLine();
					if(answer.equals("y")) {
						System.out.println(num+"번째 학생 정보 기록");
						break;
					}else if(answer.equals("n")){
						break loopOut; 
					}else {
						System.out.println("잘못 입력 하셨습니다. 다시 입력하십시오");
					}
				}		
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
	public void scoreRead() {
		//저장된 성적을 토대로 읽어와서 각 학생별 과목별 점수와 총점 평균을 출력
		int kor = 0, eng = 0, mat = 0, sum = 0, sumS = 0;
		double avg = 0.0, avgS = 0.0;
		int count = 0; //몇명의 학생인지 or 반복문이 실행된 횟수(둘다 같은 개념)
		
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream("score.dat"));
			while(true) {
				kor = dis.readInt();
				eng = dis.readInt();
				mat = dis.readInt();
				sum = dis.readInt();
				sumS += sum;
				avg = dis.readDouble();
				avgS += avg;
				System.out.println((count+1)+"번째 학생");
				count++;
				System.out.println("국어=====영어=====수학=====총점=====평균");
				//System.out.println(dis.readInt()+"     "+dis.readInt()+"     "+dis.readInt()+"     "+dis.readInt()+"     "+dis.readDouble());
				System.out.println(kor+"     "+eng+"     "+mat+"     "+sum+"     "+avg);
				//국,영,수,총점,평균 출력
			}
		}catch (EOFException e) {
			System.out.println("읽은 횟수     전체 총점 평균     전체 평균");
			System.out.println(count+"     "+sumS/3+"     "+avgS/3);
			System.out.println("score.dat 파일 읽기 완료");
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
