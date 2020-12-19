package 지뢰찾기;

import java.util.Scanner;

public class MineMenu {

	Scanner sc = new Scanner(System.in);
	Game game = new Game();
	
	//메뉴 출력함수
	public void mineMenu() {
		while(true) {
			System.out.print("게임을 시작하시겠 습니까? (y/n) >>");
			if(sc.next().charAt(0) == 'y' || sc.next().charAt(0) == 'Y') {
				System.out.println("맵의 크기를 입력하시오(ex.10) ");
				System.out.print("5x5 / 10x10 / 20x20 >>");
				game.gameStart(sc.nextInt());
			}else {
				System.out.println("수고하셨습니다.");
				break;
			}
		}
	}
}
