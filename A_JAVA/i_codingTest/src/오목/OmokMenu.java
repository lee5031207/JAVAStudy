package 오목;

import java.util.Scanner;

public class OmokMenu {

	Scanner sc = new Scanner(System.in);
	Map map = new Map();
	Check check = new Check();
	
	public void omokMenu() {
	
		Character[][] board = map.makeMap();
		
		System.out.println("오목 게임입니다 (흑 선공●/백 후공○)");
		System.out.println("제작자 : 이성욱");
		map.printMap(board);	
		int x,y = 0;
		boolean black = true;
		while (true) {
			if(black) {
				System.out.print("흑● x,y 좌표 >>");
				x = sc.nextInt();
				y = sc.nextInt();
				board[x][y] = '●';
				map.printMap(board);
				System.out.println(check.aroundCheck(x, y, '●', board));
				black = false;
			}else {
				System.out.print("백○ x,y 좌표 >>");
				x = sc.nextInt();
				y = sc.nextInt();
				board[x][y] = '○';
				map.printMap(board);
				System.out.println(check.aroundCheck(x, y, '○', board));
				black = true;
			}
		}
	}
	
}
