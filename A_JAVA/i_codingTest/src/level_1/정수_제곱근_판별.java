package level_1;

import java.math.*;

public class 정수_제곱근_판별 {

	public static void main(String[] args) {
		System.out.println(solution2(14641));
	}
    public static long solution(long n) {
        long answer = 0;
        for(int i=1; i<=n; i++) {
        	if(i*i==n) {
        		answer = (i+1)*(i+1);
        		break;
        	}else {
        		answer = -1;
        	}
        }
        return answer;
    }
    
    public static long solution2(long n) {
        long answer = 0;
        double a = Math.floor(Math.sqrt(n));
        if(a*a == n) {
        	answer = (long) ((a+1)*(a+1));
        }else {
        	answer = -1;
        }
        return answer;
    }
}
