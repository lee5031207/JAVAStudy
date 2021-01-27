package level_1;

public class 핸드폰번호_가리기 {

	public static void main(String[] args) {
		System.out.println(solution("01033334444"));
	}
	
	public static String solution(String phone_number) {
        String answer = "";
        String last = phone_number.substring(phone_number.length()-4,phone_number.length());
        for(int i=0; i<phone_number.length()-4; i++) {
        	answer += '*';
        }
        answer = answer.concat(last);
        return answer;
    }

}
