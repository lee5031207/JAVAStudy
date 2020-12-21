package 오목;

public class Map {

	public Character[][] makeMap2(){
		Character[][] map = new Character[19][19];
		//○● . ┌ ┐└ ┘├ ┬ ┤┴ ┼
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				if(i==0 && j==0) {
					map[i][j] = '┌';
				}else if(i==0 && j==18) {
					map[i][j] = '┐';
				}else if(i==18 && j==0) {
					map[i][j] = '└';
				}else if(i==18 && j==18) {
					map[i][j] = '┘';
				}else if(i==0) {
					map[i][j] = '┬';
				}else if(j==0) {
					map[i][j] = '├';
				}else if(i==18) {
					map[i][j] = '┴';
				}else if(j==18) {
					map[i][j] = '┤';
				}else {
					map[i][j] = '┼';
				}
			}
		}
		return map;
	}
	
	public void printMap2(Character[][] map) {
		System.out.println("    0      3       6       9      12     15     18");
		for(int i=0; i<19; i++) {
			if(i<10) {
				System.out.print("0"+i);
			}else {
				System.out.print(i);
			}
			for(int j=0; j<19; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}
	}
	
	public Character[][] makeMap(){
		Character[][] map = new Character[21][21];
		//○● . ┌ ┐└ ┘├ ┬ ┤┴ ┼
		for(int i=0; i<21; i++) {
			for(int j=0; j<21; j++) {
				if(i==1 && j==1) {
					map[i][j] = '┌';
				}else if(i==1 && j==19) {
					map[i][j] = '┐';
				}else if(i==19 && j==1) {
					map[i][j] = '└';
				}else if(i==19 && j==19) {
					map[i][j] = '┘';
				}else if(i==1 && j!=0  && j!=20) {
					map[i][j] = '┬';
				}else if(j==1 && i!=0  && i!=20) {
					map[i][j] = '├';
				}else if(i==19 && j!=0  && j!=20) {
					map[i][j] = '┴';
				}else if(j==19 && i!=0  && i!=20) {
					map[i][j] = '┤';
				}else if(i==0 || i==20 || j==0 || j==20) {
					map[i][j] = '■';
				}else {
					map[i][j] = '┼';
				}
			}
		}
		return map;
	}
	
	public void printMap(Character[][] map) {
		System.out.println("    1      4       7      10      13     16     19");
		for(int i=1; i<=19; i++) {
			if(i<10) {
				System.out.print("0"+i);
			}else {
				System.out.print( i );
			}
			for(int j=1; j<=19; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}	
	}
}
