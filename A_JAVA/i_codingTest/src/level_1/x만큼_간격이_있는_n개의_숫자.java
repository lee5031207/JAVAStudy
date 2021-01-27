package level_1;

public class x만큼_간격이_있는_n개의_숫자 {

	public static void main(String[] args) {
		
		solution(-4, 3);
	}
	
	public static long[] solution(int x, int n) {
        long[] answer = new long[n];
       
        for(int i=0; i<n; i++) {
        	answer[i] = x + (x*i); 
        	System.out.print(answer[i]);
        }
   
        return answer;
    }

}
