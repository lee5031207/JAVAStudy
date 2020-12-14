package level_1;

import java.util.ArrayList;
import java.util.List;

public class 시저_암호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(solution("AB", 1));
		System.out.println(solution("a B z dZFs sdwe AS s", 4));
		//System.out.println(solution("aBz", 4));
	}
	public static String solution(String s, int n) {
        String answer = "";
        List<Character> upperList = new ArrayList<Character>();
        List<Character> lowerList = new ArrayList<Character>();
        for(int i=65; i<=90; i++) {
        	upperList.add((char)i);
        	lowerList.add((char)(i+32));
        }
        System.out.println(upperList);
        System.out.println(lowerList);
        
        int findIndex = 0;
        for(int i=0; i<s.length(); i++) {
        	if(Character.isLowerCase(s.charAt(i))==true) { //소문자면
        		findIndex = lowerList.indexOf(s.charAt(i))+n;
        		if(findIndex>25) {
        			findIndex -= 26;
        			answer += lowerList.get(findIndex);
        		}else {
        			answer += lowerList.get(findIndex);
        		}
        	}else if(Character.isUpperCase(s.charAt(i))==true){ //대문자면
        		findIndex = upperList.indexOf(s.charAt(i))+n;
        		if(findIndex>25) {
        			findIndex -= 26;
        			answer += upperList.get(findIndex);
        		}else {
        			answer += upperList.get(findIndex);
        		}        		
        	}else {
        		answer += " ";
        	}
        }        
        return answer;
    }

}
