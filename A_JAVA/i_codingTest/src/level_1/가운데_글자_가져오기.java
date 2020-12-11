package level_1;

public class 가운데_글자_가져오기 {

	public static void main(String[] args) {
		//단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 
		//단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
//		System.out.println(solution("abcdefg"));
		System.out.println(solution("abcdefgh"));
	}
	public static String solution(String s) {
		String answer = "";
		int length = s.length();
        if(length%2==0) { //abcdef -> cd
        	char result1 = s.charAt(length/2-1);
        	char result2 = s.charAt(length/2);
        	answer = Character.toString(result1)+Character.toString(result2);
        }else {
        	char result = s.charAt(length/2);
        	answer = Character.toString(result);
        }
        return answer;
    }
}
