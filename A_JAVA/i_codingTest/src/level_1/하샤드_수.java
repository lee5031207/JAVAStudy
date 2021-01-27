package level_1;

public class 하샤드_수 {

	public static void main(String[] args) {
		System.out.println(solution(11));
	}
	
	public static boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        int x2 = x;
        
        while(x>0) {
        	sum += x%10;
        	x = x/10;
        }
        
        
        if(x2%sum==0) {
        	answer = true;
        }else {
        	answer = false;
        }
       
        return answer;
    }
	
	

}
