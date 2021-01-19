package level_1;

public class 짝수와_홀수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(3));
	}
	
    public static String solution(int num) {
        String answer = "";
        if(num%2==0) {
        	answer = "Even";
        }else {
        	answer = "Odd";
        }
        return answer;
    }

}
