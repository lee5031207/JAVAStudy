package level_1;

import java.util.ArrayList;

public class 다트게임 {

	public static void main(String[] args) {
		String dartResult = "1S*2T*3S";
		System.out.println(solution(dartResult));
		
	}
    public static int solution(String dartResult) {
    	
        int answer = 0;
        ArrayList<String> tempList = new ArrayList<String>();
        String tempStr = "";
        
        for(int i=0; i<dartResult.length(); i++) {
        	if(Character.isDigit(dartResult.charAt(i))){ 
        		//1. 숫자라면
        		if(dartResult.charAt(i+1) == '0') {
        			//1-1. 숫자인데 뒤에 0 이면
        			i++; // 다음은 넘어가도록 ++해준다
        			tempStr += dartResult.charAt(i)+'0';
        		}else {
        			//1-2. 뒤에 0이아님 
        			tempStr += dartResult.charAt(i);
        		}        		
        	}else if((int)dartResult.charAt(i) >= 65 && (int)dartResult.charAt(i) <= 90) {
        		//2. 알파벳이면
        		tempStr += dartResult.charAt(i);
        		tempList.add(tempStr);
        		tempStr = "";
        	}else if(dartResult.charAt(i) == '*' || dartResult.charAt(i) == '#') {
        		//3. 옵션이면
        		tempStr += dartResult.charAt(i);
    			tempList.add(tempStr);
    			tempStr = "";
        	}
        }
        
        System.out.println(tempList);
        
        
        
        
        return answer;
        
    }

}
