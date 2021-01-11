package level_1;

import java.util.ArrayList;
import java.util.Collections;

public class 정수_내림차순으로_배치 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(97135));
	}
	
	//Collection 사용한 방법 
	public static long solution(long n) {
        long answer = 0;
        String strN = Long.toString(n);
        ArrayList<Character> list = new ArrayList<Character>();
        for(int i=0; i<strN.length(); i++) {
        	list.add(strN.charAt(i));
        }
        Collections.sort(list);
        Collections.reverse(list);
        strN = "";
        for(int i=0; i<list.size(); i++) {
        	strN += list.get(i);
        }
        answer = Long.parseLong(strN);
        return answer;
    }
	
	//Collection 사용 X
	public static long solution2(long n) {
        long answer = 0;
        boolean flag = true;
        
        while(flag) {
        	
        }
        
        
        return answer;
    }

}
