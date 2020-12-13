package level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 문자열_내림차순_정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("Zbcdefg");
	} 
	public static String solution(String s) {
        String answer = "";
        
        List<Character> smallList = new ArrayList<Character>();
        List<Character> bigList = new ArrayList<Character>();
        
        for(int i=0; i<s.length(); i++) {
        	if(Character.isLowerCase(s.charAt(i))==true) {
        		smallList.add(s.charAt(i));
        	}else if(Character.isUpperCase(s.charAt(i))==true){
        		bigList.add(s.charAt(i));
        	}
        }
        Collections.sort(smallList);
        Collections.sort(bigList);
        
        Collections.reverse(smallList);
        Collections.reverse(bigList);
        
        smallList.addAll(bigList);


        for(int i=0; i<smallList.size(); i++) {
        	answer += Character.toString(smallList.get(i));
        }
        System.out.println(answer);
        //answer = smallList.toString().replaceAll("^\\[", "").replaceAll("\\]$", "").replace(",", "").replaceAll(" ", "");
        return answer;
    }

}
