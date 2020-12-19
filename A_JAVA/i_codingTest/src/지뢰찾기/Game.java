package 지뢰찾기;

import java.util.Scanner;

public class Game {

	Map map = new Map();
	Scanner sc = new Scanner(System.in);
	Check check = new Check();
	
	//게임을 시작하는 함수
	public void gameStart(int size) {
		System.out.println("==="+size+"x"+size+"지뢰찾기 게임을 시작합니다===");
		//답안지 맵, 답안 맵 가져오기
		Character[][] answerMap = map.answerMap(size);
		Character[][] answerSheetMap = map.answerSheetMap(size);
		
		int x = 0,y = 0;
		boolean flag = true;
		map.printMap(answerMap);
		map.printMap(answerSheetMap);
		while(flag) {
			System.out.print("지뢰 위치 기록(1) / 땅 뒤집기(2) / 답안지 제출(3) >>");
			switch (sc.nextInt()) {
			case 1:
				System.out.print("x,y 좌표를 입력하시오(1~10) >>");
				x = sc.nextInt();
				y = sc.nextInt();
				answerSheetMap = check.mineCheck(x, y, answerSheetMap);
				map.printMap(answerSheetMap);
				break;
			case 2:
				System.out.print("x,y 좌표를 입력하시오(1~10) >>");
				x = sc.nextInt();
				y = sc.nextInt();
				System.out.println("("+x+","+y+")를 입력하셨습니다");
				if(answerMap[x][y] == '0') { //0이라면 aroundCheck() 시작
					answerSheetMap[x][y] = '0';
					answerSheetMap = check.aroundCheck(x, y, answerMap, answerSheetMap);
				}else if(answerMap[x][y] == 'X'){  //X 라면 지뢰 고른것
					System.out.println("**********지뢰입니다!**********");
					flag = false;
				}else { //0,X  가아니면 1,2등 숫자만 오픈해줌
					answerSheetMap[x][y] = answerMap[x][y];
				}
				map.printMap(answerSheetMap);
				break;
			case 3:
				System.out.print("답안지를 제출하시겠습니까?");
				if(sc.next().charAt(0) == 'y' || sc.next().charAt(0) == 'Y') {
					System.out.println(check.answerCheck(size, answerMap, answerSheetMap));
					System.out.println("수고하셨습니다!");
				}
				flag = false;
				break;
			default:
				break;
			}
		}
		
		
	}
}
