package 강사님;

public class 배열담고출력 {

	public static void main(String[] args) {
		
//	    숫자 1부터 100까지 배열 4개에 균일하게 나누어 담고 출력해보세요.
	    /*
	    *   출력 형태
	 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25]
	[26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50]
	[51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75]
	[76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100]
	    *
	    */
		answer();
	}
	
	public static void answer() {
		int[][] result = new int[4][25];
		int count = 1;
		for(int i=0; i<result.length; i++) {
			System.out.print("[");
			for(int j=0; j<25; j++) {
				result[i][j] = count;
				count++;
				if(j!=24) {
					System.out.print(result[i][j]+",");
				}else {
					System.out.print(result[i][j]);
				}
				
			}
			System.out.print("]");
			System.out.println("");
		}
	}
}
