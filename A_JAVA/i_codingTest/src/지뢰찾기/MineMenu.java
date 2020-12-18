package 지뢰찾기;

import java.util.Scanner;

public class MineMenu {

	Scanner sc = new Scanner(System.in);
	Game game = new Game();
	
	public void mineMenu() {
		while(true) {
			System.out.print("게임을 시작하시겠 습니까? (y/n) >>");
			if(sc.next().charAt(0) == 'y') {
				game.gameStart();
			}else {
				System.out.println("수고하셨습니다.");
				break;
			}
		}
	}
}
