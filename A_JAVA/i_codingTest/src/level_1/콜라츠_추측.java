package level_1;

public class 콜라츠_추측 {

	public static void main(String[] args) {
		System.out.println(solution(626331));
	}
	
	public static int solution(int num) {
        int answer = 0;
        boolean flag = true;
        long numL = num;
        
        while(flag) {
        	if(numL==1) {
        		flag = false;
        	}else if(numL%2==0) {
        		numL = numL/2;
        		answer++;
        	}else if(numL%2==1) {
        		numL = (numL*3)+1;
        		answer++;
        	}
        	System.out.println(numL);
        }
        
        if(answer>=500) {
        	answer = -1;
        }
        
        return answer;
    }
}
