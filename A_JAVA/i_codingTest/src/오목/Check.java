package 오목;

public class Check {

	public boolean aroundCheck(int x, int y,char stone, Character[][] board) {
		//이 함수에서 게임이 끝난 건지 아닌지 리턴해주자 
		//true -> 안끝남
		//false -> 끝남 
		boolean flag = true;
		if(board[x-1][y-1] == board[x][y] || board[x+1][y+1] == board[x][y]) {
			//좌상중우하 확인하는 함수 
		}else if(board[x][y-1] == board[x][y] || board[x][y+1] == board[x][y]) {
			//양옆으로 확인하는 함수
			System.out.println("sidecheck실행!");
			System.out.println(sideCheck(x, y, stone, board));
			//****************************여기서 실행이 안됨 왜그러지?************************************
			
		}else if(board[x+1][y-1] == board[x][y] || board[x-1][y+1] == board[x][y]) {
			//좌하중우상 확인하는 함수
		}else if(board[x-1][y] == board[x][y] || board[x+1][y] == board[x][y]) {
			//위아래로 확인하는 함수 
		}
		return flag;
	}
	
	public boolean sideCheck(int x, int y, char stone, Character[][] board) {
		int[] left = new int[2];  
		int[] right = new int[2];
		
		// 가장 왼쪽과 오른쪽 검정돌의 위치를 확보
		for(int i=y; i>=0; i--) {
			if(board[x][i] == stone) {
				left[0] = x;
				left[1] = i;    
			}else {
				break;
			}
		}
		for(int i=y; i<=18; i++) {
			if(board[x][i] == stone) {
				right[0] = x;
				right[1] = i;
			}else {
				break;
			}
		}
		//이제 왼쪽부터 연속된 돌의 수를 카운트
		int count = 0;
		for(int i=left[1]; i<=right[1]; i++) {
			if(board[x][i] == stone) {
				count++;
			}else if(board[x][i] != stone) {
				count = 0;
			}
			if(count == 5) {
				break;
			}
		}
		//5개의 연속된 돌이 있으면 false반환
		if(count==5) {
			return false;
		}else {
			return true;
		}
	}
}
