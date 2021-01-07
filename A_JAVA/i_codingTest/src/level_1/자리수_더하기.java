package level_1;

public class 자리수_더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(123);
	}
    public static int solution(int n) {
        int answer = 0;
        String strN = Integer.toString(n);
        for(int i=0; i<strN.length(); i++) {
        	answer += Character.getNumericValue(strN.charAt(i));
        }
        System.out.println(answer);
        return answer;
    }

}
