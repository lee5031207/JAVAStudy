package com.car;

public class 지뢰찾기 {

	public static void main(String[] args) {
		Character[][] resultmap = map();
	}
	
	
	
	public static Character[][] map(){
		
		//지뢰 매설
		Character[][] map = new Character[10][10];
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.toString(0).charAt(0);
			}
		}
		int row,col = 0;
		for(int i=0; i<10; i++) {
			row = (int) (Math.random()*9);
			col = (int) (Math.random()*10);
			if(map[row][col] != '0') {
				try {
					map[row+1][col+1] = 'X';
				}catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("보너스 지뢰가 9개!");
				}
			}else {
				map[row][col] = 'X';
			}
		}
		
		System.out.println("====지뢰 매설 완료====");
		for (Character[] rows : map) {
			for (Character cols : rows) {
				System.out.print(cols+" ");
			}
			System.out.println("");
		}
		
		//지뢰 표지판(1,2...)심기
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(map[i][j].equals('X')) { //지뢰의 위치를찾았다
					try {
						map[i-1][j-1] = (char)((int)map[i-1][j-1] + 1);
						map[i-1][j] = (char)((int)map[i-1][j] + 1);
						map[i-1][j+1] = (char)((int)map[i-1][j+1] + 1);
						map[i][j-1] = (char)((int)map[i][j-1] + 1);
						map[i][j+1] = (char)((int)map[i-1][j+1] + 1);
						map[i+1][j-1] = (char)((int)map[i+1][j-1] + 1);
						map[i+1][j] = (char)((int)map[i+1][j] + 1);
						map[i+1][j+1] = (char)((int)map[i+1][j+1] + 1);
					}catch (ArrayIndexOutOfBoundsException e){
						System.out.println(e);
					}
				}
			}
		}
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(!isNumberic(map[i][j])) { //지뢰의 위치를찾았다
					try {
						map[i][j] ='X';
					}catch (ArrayIndexOutOfBoundsException e){
						
					}
				}
			}
		}
		
		
		System.out.println("====지뢰 표지판 매설 완료====");
		for (Character[] rows : map) {
			for (Character cols : rows) {
				System.out.print(cols+" ");
			}
			System.out.println("");
		}
		
		return map;
	}
	
	public static boolean isNumberic(Character ch) { //숫자 판별 함수
		String s = Character.toString(ch);
		try {
	     	Double.parseDouble(s);
	    	return true;
	    } catch(NumberFormatException e) {  //문자열이 나타내는 숫자와 일치하지 않는 타입의 숫자로 변환 시 발생
	    	return false;
	    }
	}
	
}
