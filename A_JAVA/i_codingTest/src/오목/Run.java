package 오목;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new OmokMenu().omokMenu();	
	}
	//========================좌하단->우상단 연속된 돌을 확인하는 함수========================
	public boolean leftUpDiagonal(int x, int y, char stone, Character[][] board) {
		int[] leftBottom = new int[2];
		int[] rightTop = new int[2];
		int i=x;
		int j=y;
		boolean flag = true;
		while (flag) {
			if(i <= 19 && j >= 1) {
				if(board[i][j].equals(stone)) {
					leftBottom[0] = i;
					leftBottom[1] = j;
				}
				i++; j--;
			}else {
				flag = false;
			}	
		}
		//여기부터 해야댐
		
		
		return false;	
	}

}
