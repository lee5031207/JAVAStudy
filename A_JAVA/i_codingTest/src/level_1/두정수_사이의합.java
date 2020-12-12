package level_1;

public class 두정수_사이의합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(3, 5));
	}
    public static long solution(int a, int b) {
        long answer = 0;
        int c = 0;
        if(a>b) {
        	c = a;
        	a = b;
        	b = c;
        	
        }
        for(int i=a; i<=b; i++) {
        	answer += i;
        }
        return answer;
    }

}
