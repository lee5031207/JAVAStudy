package 지뢰찾기;

import java.util.Scanner;

public class Game {

	Map map = new Map();
	Scanner sc = new Scanner(System.in);
	
	public void gameStart() {
		System.out.println("Game Start");
		System.out.println("10x10 지뢰찾기 게임입니다.");
		
		//답안지 맵, 답안 맵 가져오기
		Character[][] answerMap = map.answerMap();
		Character[][] answerSheetMap = map.answerSheetMap();
		int x,y = 0;
		while(true) {
			map.printMap(answerSheetMap);
			System.out.print("x,y 좌표를 입력하시오(1~10) >>");
			x = sc.nextInt();
			y = sc.nextInt();
			System.out.println("("+x+","+y+")를 입력하셨습니다");
			if(answerMap[x][y] == '0') {
				answerSheetMap[x][y] = '0';
				map.printMap(answerMap);
				map.printMap(answerSheetMap);
			}else {
				answerSheetMap[x][y] = answerMap[x][y];
			}
		}
		
		
	}
}
