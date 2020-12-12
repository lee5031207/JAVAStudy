package level_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 나누어떨어지는_숫자배열 {

	public static void main(String[] args) {
		
		int[] arr = {3,2,6};
		solution(arr, 10);
		
	}
	
    public static int[] solution(int[] arr, int divisor) {
        
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++) {
        	if(arr[i]%divisor == 0) {
        		list.add(arr[i]);
        	}
        }
        if(list.size()==0) {
        	list.add(-1);
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        }

        return answer;
    }

}
