package 지뢰찾기;

public class Check {

	Around around = new Around();
	// 좌표를 입력시 그 좌표가 0->true 반환하는 함수
	public boolean zeroCheck(int x, int y, Character[][] answerMap) {
		if(answerMap[x][y].equals('0')) {
			return true;
		}else {
			return false;
		}
	}
	
	//주변 8개 좌표를 확인해 0이면 재귀 호출, 0이아니면 그냥 답안지 만 까뒤집는 함수 !!!!핵심!!!!
	public Character[][] aroundCheck(int x, int y, Character[][] answerMap, Character[][] answerSheetMap) {
		int[][] aroundArray = around.returnAround(x, y); //주변 8개 좌표를 리턴하는 함수
		for(int i=0; i<8; i++) { //주변 8개 좌표를 하나하나 비교한다
			if(zeroCheck(aroundArray[i][0], aroundArray[i][1], answerMap) && answerSheetMap[aroundArray[i][0]][aroundArray[i][1]] == '□') { //0이라면
				answerSheetMap[aroundArray[i][0]][aroundArray[i][1]] = '0'; //답안지를 0으로 바꾸고
				answerSheetMap = aroundCheck(aroundArray[i][0], aroundArray[i][1], answerMap, answerSheetMap); //재귀함수 호출
			}else { //0이 아니라면
				answerSheetMap[aroundArray[i][0]][aroundArray[i][1]] = //답안지에 1,2 등 숫자표시하고 끝 
						answerMap[aroundArray[i][0]][aroundArray[i][1]];
			}
		}
		return answerSheetMap;
	}
	
	//플레이어가 지뢰라 생각되는 곳에 깃발(●) 표시를 하는 함수
	public Character[][] mineCheck(int x,int y, Character[][] answerSheetMap){
		if(answerSheetMap[x][y] == '□') {
			answerSheetMap[x][y] = '●';
		}else if(answerSheetMap[x][y] == '●'){
			answerSheetMap[x][y] = '□';
		}
		return answerSheetMap;
	}
	
	//플레이어가 답안을 제출하면 답안을 확인하는 함수
	public String answerCheck(int size, Character[][] answerMap, Character[][] answerSheetMap) {
		int score = 0;
		for(int i=1; i<=size; i++) {
			for(int j=1; j<=size; j++) {
				if(answerSheetMap[i][j] == '●') {
					if(answerMap[i][j] == 'X') {
						score++;
					}else {
						return "=====오답입니다=====";
					}
				}else {
					return "=====오답입니다=====";
				}
			}
		}
		return "=====정답입니다!! 점수 : "+score+"점=====";
	}
	
}
