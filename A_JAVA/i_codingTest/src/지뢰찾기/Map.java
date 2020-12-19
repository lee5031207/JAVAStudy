package 지뢰찾기;

public class Map {

	// answerSheetMap 생성하는 함수
	public Character[][] answerSheetMap(int size){
		Character[][] map = new Character[size+2][size+2];
		for(int i=0; i<size+2; i++) {
			for(int j =0; j<size+2; j++) {
				if(i==0 || i==size+1 || j==0 || j==size+1) {
					map[i][j] = '■';
				}else {
					map[i][j] = '□';
				}
			}
		}
		return map; 
	}
	
	
	// answerMap 생성하는 함수
	public Character[][] answerMap(int size){ 
		 //0으로 초기화된 2차원배열 map 선언
		 Character[][] map = new Character[size+2][size+2];
		 for(int i=0; i<size+2; i++) {
				for(int j=0; j<size+2; j++) {
					map[i][j] = '0';
				}
		 }
		 //지뢰개수 size별로 다르니 구분하자
		 //5x5 -> 3개, 10x10 -> 8개  20x20 ->15개
		 int mineCnt = 0;
		 switch (size) {
		case 5:
			mineCnt = 3;
			break;
		case 10:
			mineCnt = 8;
			break;
		case 20:
			mineCnt = 15;
			break;
		default:
			break;
		}
		 
		int row, col =0;
		for(int i=0; i<mineCnt; i++) {
			row = (int)(Math.random()*mineCnt)+1;
			col = (int)(Math.random()*mineCnt)+1;
			if(map[row][col] != '0') { //만약 중복 된다면
				map[col][row] = 'X';   //row, col 거꾸로 지뢰 심기
			}else {
				map[row][col] = 'X';   //0이라면 그자리에 지뢰 심기
			}
		}
		//지뢰 표지판(1,2...)심기
		for(int i=1; i<=size; i++) {
			for(int j=1; j<=size; j++) {
				if(!isNumberic(map[i][j])) {
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
		}
		for(int i=1; i<=size; i++) {
			for(int j=1; j<=size; j++) {
				if(!isNumberic(map[i][j])) {
					  map[i][j] = 'X';	
				}
			}
		}
		for(int i=0; i<size+2; i++) {
			for(int j=0; j<size+2; j++) {
				if(i==0 || i==size+1 || j==0 || j==size+1) {
					map[i][j] = '■';
				}
			}
		}
		return map;
	 }
	
	//숫자 판별 함수
	public static boolean isNumberic(Character ch) { 
		String s = Character.toString(ch);
		try {
	     	Double.parseDouble(s);
	    	return true;
	    } catch(NumberFormatException e) {  
	    	//문자열이 나타내는 숫자와 일치하지 않는 타입의 숫자로 변환 시 발생
	    	return false;
	    }
	}
	
	//Map을 출력하는 함수 
	public void printMap(Character[][] map) {
		for (Character[] characters : map) {
			for (Character ch : characters) {
				System.out.print(ch+" ");
			}System.out.println("");
		}
	}
}
