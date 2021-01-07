package level_1;

import java.util.ArrayList;

public class 이상한문자_만들기 {

	public static void main(String[] args) {
		solution("try hello world    ");
	}
	
	public static String solution(String s) {
		
        String answer = "";
        //문자열 " "기준으로 나누기
        //-1을 해주는 이유 뒤에 공백을 살리기 위해, 최대 -1개?
        String[] word = s.split(" ",-1); 
        System.out.println(word.length);
        
        for(int i=0; i<word.length; i++) {
        	for(int j=0; j<word[i].length(); j++) {
        		if(j%2==0) {
        			answer += Character.toUpperCase(word[i].charAt(j));
        		}else if(j%2==1){
        			answer += Character.toLowerCase(word[i].charAt(j));
        		}
        	}
        	if(i!=word.length-1) {
        		answer += " ";
        	}
        }
        return answer;
    }
	
}
