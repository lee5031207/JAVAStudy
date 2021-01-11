package level_1;

import java.util.ArrayList;

public class 자연수뒤집어_배열로만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution2(1234567890);
	}
    public static int[] solution(long n) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean flag = true;
        while(flag) {
        	if(n>=10) {
        		list.add((int)(n%10));
        		n = n/10;
        	}else {
        		flag = false;
        	}
        }
        return answer;
    }
    public static int[] solution2(long n) {
    	String strN = Long.toString(n);
        int[] answer = new int[strN.length()];
        
        for(int i=0; i<strN.length(); i++) {
        	if(n>=10) {
        		answer[i] = (int) (n%10);
        		n = n/10;
        	}else {
        		answer[i] = (int) n;
        	}
        }
        
        return answer;
    }

}
