package level_1;

import java.util.ArrayList;
import java.util.Collections;

public class 예산 {

	public static void main(String[] args) {
		int[] d = {2,2,3,3};
		int budget = 10;
		solution(d, budget);

	}
	
	public static int solution(int[] d, int budget) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<d.length; i++) {
        	list.add(d[i]);
        }
        Collections.sort(list);
        System.out.println(list);
        
        for(int i=0; i<list.size(); i++) {
        	if(budget-list.get(i) >= 0) {
        		budget -= list.get(i);
        		answer++;
        	}else {
        		break;
        	}
        }
        
        System.out.println(answer);
        
        return answer;
    }

}
