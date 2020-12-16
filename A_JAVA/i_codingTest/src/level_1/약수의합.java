package level_1;

public class 약수의합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(36));
	}
    public static int solution(int n) {
        int answer = 0;
        for(int i=n; i>0; i--) {
        	if(n%i==0) {
        		answer += n/i;
        	}
        }     
        return answer;
    }

}
