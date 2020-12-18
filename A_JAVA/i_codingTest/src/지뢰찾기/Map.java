package 지뢰찾기;

public class Map {

	// map 가져오기
	public Character[][] answerSheetMap(){
		Character[][] map = new Character[12][12];
		for(int i=0; i<12; i++) {
			for(int j=0; j<12; j++) {
				if(i==0 || i==11 || j==0 || j==11) {
					map[i][j] = '=';
				}else {
					map[i][j] = 'Ο';
				}
			}
		}
		
		return map;
	}
	// answerMap 가져오기
	public Character[][] answerMap(){
		//0으로 초기화된 2차원배열 map 선언
		Character[][] map = new Character[12][12];
		for(int i=0; i<12; i++) {
			for(int j=0; j<12; j++) {
				map[i][j] = Integer.toString(0).charAt(0);
			}
		}
		//map에 지뢰 'X' 깔기
		int row, col =0;
		for(int i=0; i<10; i++) { //지뢰 개수 10개 선언
			row = (int)(Math.random()*10)+1;
			col = (int)(Math.random()*10)+1;
			if(map[row][col] != '0') { //만약 중복 된다면
				map[col][row] = 'X';   //row,col 거꾸로 지뢰 심기
			}else {
				map[row][col] = 'X';   //0이라면 그자리에 지뢰 심기
			}
		}
		//지뢰 표지판(1,2...)심기
		for(int i=1; i<11; i++) {
			for(int j=1; j<11; j++) {
				if(!isNumberic(map[i][j])) { //숫자가 아니라면
					map[i-1][j-1] = (char)((int)map[i-1][j-1] + 1);
					map[i-1][j] = (char)((int)map[i-1][j] + 1);
					map[i-1][j+1] = (char)((int)map[i-1][j+1] + 1);
					map[i][j-1] = (char)((int)map[i][j-1] + 1);
					map[i][j+1] = (char)((int)map[i][j+1] + 1);  //주변에 +1 해주기
					map[i+1][j-1] = (char)((int)map[i+1][j-1] + 1);
					map[i+1][j] = (char)((int)map[i+1][j] + 1);
					map[i+1][j+1] = (char)((int)map[i+1][j+1] + 1);
				}
			}
		}//표지판 심을 때 바뀐 Y,Z로 바뀐 지뢰 다시 X로
		for(int i=1; i<11; i++) {
			for(int j=1; j<11; j++) {
				if(!isNumberic(map[i][j])) {
					  map[i][j] = 'X';	
				}
			}
		}
		for(int i=0; i<12; i++) {
			for(int j=0; j<12; j++) {
				if(i==0 || i==11 || j==0 || j==11) {
					map[i][j] = '=';
				}
			}
		}
		return map;
	}
	
	public static boolean isNumberic(Character ch) { //숫자 판별 함수
		String s = Character.toString(ch);
		try {
	     	Double.parseDouble(s);
	    	return true;
	    } catch(NumberFormatException e) {  
	    	//문자열이 나타내는 숫자와 일치하지 않는 타입의 숫자로 변환 시 발생
	    	return false;
	    }
	}
	
	public void printMap(Character[][] map) {
		for (Character[] characters : map) {
			for (Character ch : characters) {
				System.out.print(ch+" ");
			}System.out.println("");
		}
	}
}
