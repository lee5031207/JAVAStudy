package 지뢰찾기;

public class Check {

	Around around = new Around();
	// 좌표를 입력시 그 좌표가 0이면 false, 0이 아니면 true 반환하는 함수
	public boolean zeroCheck(int x, int y, Character[][] answerMap) {
		if(!answerMap[x][y].equals('0')) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean[] aroundCheck(int x, int y, Character[][] answerMap) {
		boolean[] result = new boolean[8];
		int[][] aroundArray = around.returnAround(x, y);
		for(int i=0; i<8; i++) {
			result[i] = zeroCheck(aroundArray[i][0], aroundArray[i][1], answerMap);
		}
		return result;
	}
}
