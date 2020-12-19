package 지뢰찾기;

import java.util.HashMap;
import java.util.Map;

public class Check {

	Around around = new Around();
	// 좌표를 입력시 그 좌표가 0이면 false, 0이 아니면 true 반환하는 함수
	public boolean zeroCheck(int x, int y, Character[][] answerMap) {
		if(answerMap[x][y].equals('0')) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * public boolean[] aroundCheck(int x, int y, Character[][] answerMap) {
	 * boolean[] result = new boolean[8]; int[][] aroundArray =
	 * around.returnAround(x, y); for(int i=0; i<8; i++) { result[i] =
	 * zeroCheck(aroundArray[i][0], aroundArray[i][1], answerMap); } return result;
	 * }
	 */
	
	//x,y는 확인할 좌표, answerMap은 정답맵(지뢰,1,2,등이 표시된) , answerSheepMap은 사용자가 확인할 답안지 맵
	public Character[][] aroundCheck(int x, int y, Character[][] answerMap, Character[][] answerSheetMap) {
		int[][] aroundArray = around.returnAround(x, y); //주변 8개 좌표를 리턴하는 함수
		for(int i=0; i<8; i++) { //주변 8개 좌표를 하나하나 비교한다
			if(zeroCheck(aroundArray[i][0], aroundArray[i][1], answerMap)) { //0이라면
				answerSheetMap[aroundArray[i][0]][aroundArray[i][1]] = '0'; //답안지를 0으로 바꾸고
				//-->여기서 재귀함수 호출 stackoverflow남
				answerSheetMap = aroundCheck(aroundArray[i][0], aroundArray[i][1], answerMap, answerSheetMap);
			}else { //0이 아니라면
				answerSheetMap[aroundArray[i][0]][aroundArray[i][1]] = //답안지에 1,2 등 숫자표시하고 끝 
						answerMap[aroundArray[i][0]][aroundArray[i][1]];
				continue;
			}
		}
		return answerSheetMap;
	}
	
	public Map<String, Character[][]> aroundCheck2(int x, int y, Character[][] answerMap, Character[][] answerSheetMap) {
		Map<String, Character[][]> result = new HashMap<String, Character[][]>(); 
		result.put("answerMap", answerMap);
		result.put("answerSheetMap", answerSheetMap);
		int[][] aroundArray = around.returnAround(x, y);
		for(int i=0; i<8; i++) {
			if(!zeroCheck(aroundArray[i][0], aroundArray[i][1], answerMap)) {
				answerSheetMap[aroundArray[i][0]][aroundArray[i][1]] = '0';
				result = aroundCheck2(aroundArray[i][0], aroundArray[i][1], answerMap, answerSheetMap);
			}else {
				answerSheetMap[aroundArray[i][0]][aroundArray[i][1]] = 
						answerMap[aroundArray[i][0]][aroundArray[i][1]];
			}
		}
		result.put("answerMap", answerMap);
		result.put("answerSheetMap", answerSheetMap);
		return result;
	}
}
