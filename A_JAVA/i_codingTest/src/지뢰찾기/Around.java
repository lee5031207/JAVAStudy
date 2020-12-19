package 지뢰찾기;

public class Around {

	//좌표의 주변 좌표 8개를 int[][] 배열로 리턴하는 함수
	public int[][] returnAround(int x, int y){
		int[][] result = new int[8][2];
		result[0][0] = x-1; result[0][1] = y-1;
		result[1][0] = x-1; result[1][1] = y;
		result[2][0] = x-1; result[2][1] = y+1;
		result[3][0] = x; result[3][1] = y-1;
		result[4][0] = x; result[4][1] = y+1;
		result[5][0] = x+1; result[5][1] = y-1;
		result[6][0] = x+1; result[6][1] = y;
		result[7][0] = x+1; result[7][1] = y+1;
		return result;
	}
}
