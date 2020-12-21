package 오목;

public class Check {

	public boolean aroundCheck(int x, int y, char stone, Character[][] board) {
		//이 함수에서 게임이 끝난 건지 아닌지 리턴해주자 
		//true -> 안끝남
		//false -> 끝남 
		boolean flag = true;
		
		if(board[x][y].equals(board[x][y-1]) || board[x][y].equals(board[x][y+1])) {
			//양옆을 확인하는 함수 sideCheck() 실행
			flag = sideCheck(x, y, stone, board);
		}
		
		if(board[x][y].equals(board[x-1][y]) || board[x][y].equals(board[x+1][y])) {
			//위아래를 확인하는 함수 topBottomCheck() 실행
			flag = topBottomCheck(x, y, stone, board);
		}
		
		if(board[x][y].equals(board[x-1][y-1]) || board[x][y].equals(board[x+1][y+1])) {
			//좌상단에서 내려오는 대각선 확인
			flag = leftDownDiagonal(x, y, stone, board);
		}
		
		if(board[x][y].equals(board[x+1][y-1]) || board[x][y].equals(board[x-1][y+1])) {
			//우상단에서 내려가는 대각선 확인
		}
		return flag;
	}
	
	//========================양옆으로 연속된 돌을  확인하는 함수========================
	public boolean sideCheck(int x, int y, char stone, Character[][] board) {
		int[] left = new int[2];  
		int[] right = new int[2];
		// 가장 왼쪽과 오른쪽 돌의 위치를 확보		
		for(int i=y; i>=1; i--) {
			if(board[x][i] == stone) {
				left[0] = x;
				left[1] = i;    
			}else {
				break;
			}
		}
		for(int i=y; i<=19; i++) {
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
		}
		//5개의 연속된 돌이 있으면 false반환
		if(count==5) {
			return false;
		}else {
			return true;
		}
	}
	
	//========================위아래로 연속된 돌의 수를 확인하는 함수========================
	public boolean topBottomCheck(int x, int y, char stone, Character[][] board) {
		int[] top = new int[2];
		int[] bottom = new int[2];
		// 가장 위의 돌과 아래의 돌 위치를 확보		
		for(int i=x; i>=1; i--) {
			if(board[i][y] == stone) {
				top[0] = i;
				top[1] = y;
			}else {
				break;
			}
		}
		for(int i=x; i<=19; i++) {
			if(board[i][y] == stone) {
				bottom[0] = i;
				bottom[1] = y;
			}else {
				break;
			}
		}
		//이제 위에서 아래로 연속된 돌의 수를 카운트
		int count = 0;
		for(int i=top[0]; i<=bottom[0]; i++) {
			if(board[i][y] == stone) {
				count++;
			}else if(board[i][y] != stone) {
				count = 0;
			}
		}
		
		//5개의 연속된 돌이 있으면 false반환
		if(count==5) {
			return false;
		}else {
			return true;
		}
	}
	//========================좌상단->우하단 연속된 돌을 확인하는 함수========================
	public boolean leftDownDiagonal(int x,int y, char stone, Character[][] board) {
		int[] leftTop = new int[2];
		int[] rightBottom = new int[2];
		
		int i=x;
		int j=y;
		boolean flag = true;
		while (flag) {
			if(i>=1 && j>=1) {
				if(board[i][j] == stone) {
					leftTop[0] = i;
					leftTop[1] = j;
				}
				i--;j--;
			}else {
				flag = false;
			}
		}
		System.out.println("leftTop : ["+leftTop[0]+","+leftTop[1]+"]");
		i=x; j=y; flag = true;
		while (flag) {
			if(i<=19 && j<=19) {
				if(board[i][j] == stone) {
					rightBottom[0] = i;
					rightBottom[1] = j;
				}
				i++; j++;
			}else {
				flag = false;
			}
		}
		System.out.println("rightBottom : ["+rightBottom[0]+","+rightBottom[1]+"]");
		int count = 0;
		i = leftTop[0]; j=leftTop[1]; flag = true;
		while(flag) {
			if(i <= rightBottom[0] && j <= rightBottom[1]) {
				if(board[i][j].equals(stone)) {
					count++;
				}else if (!board[i][j].equals(stone)) {
					count = 0;
				}
				i++;j++;
			}else {
				flag = false;
			}
		}
		System.out.println("while문 밖 count :"+count);
		//5개의 연속된 돌이 있으면 false반환
		if(count==5) {
			return false;
		}else {
			return true;
		}
	}
}
