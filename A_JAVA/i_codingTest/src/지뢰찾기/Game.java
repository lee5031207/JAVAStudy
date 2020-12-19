package 지뢰찾기;

import java.util.Scanner;

public class Game {

	Map map = new Map();
	Scanner sc = new Scanner(System.in);
	Check check = new Check();
	
	public void gameStart() {
		System.out.println("Game Start");
		System.out.println("10x10 지뢰찾기 게임입니다.");
		
		//답안지 맵, 답안 맵 가져오기
		Character[][] answerMap = map.answerMap();
		Character[][] answerSheetMap = map.answerSheetMap();
		int x,y = 0;
		map.printMap(answerSheetMap);
		while(true) {
			System.out.print("x,y 좌표를 입력하시오(1~10) >>");
			x = sc.nextInt();
			y = sc.nextInt();
			System.out.println("("+x+","+y+")를 입력하셨습니다");
			if(answerMap[x][y] == '0') { //0이라면 aroundCheck() 시작
				answerSheetMap[x][y] = '0';
				answerSheetMap = check.aroundCheck(x, y, answerMap, answerSheetMap);
			}else if(answerMap[x][y] == 'X'){  //X 라면 지뢰 고른것
				System.out.println("지뢰입니다!");
				break;
			}else { //0,X  가아니면 1,2등 숫자만 오픈해줌
				answerSheetMap[x][y] = answerMap[x][y];
			}
			map.printMap(answerMap);
			map.printMap(answerSheetMap);
		}
		
		
	}
}
