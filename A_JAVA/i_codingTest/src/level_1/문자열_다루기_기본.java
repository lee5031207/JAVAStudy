package level_1;

public class 문자열_다루기_기본 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution("34234"));
	}
	public static boolean solution(String s) {
        boolean answer = false;
        int len = s.length();
    	for(int i=0; i<len; i++) {
    		if(Character.isDigit(s.charAt(i)) == false) {
    			return false; 
    		}
    	}
        if(len==4 || len==6) {
        	answer = true;
        }
        return answer;
    }

}
