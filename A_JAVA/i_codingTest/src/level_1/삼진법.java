package level_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 삼진법 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		solution(45); // 45->1200->0021->7
		System.out.println(solution(54344));
//		solution(245);
	}
	
	
	public static int solution(int n) {
        int answer = 0, count = 0;
        int a = 1;
		while(true) {
			if(n/a == 0) {
				break;
			}else {
				a *= 3;
				count++;
			}
		}
		a /= 3;
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=1; i<=count; i++) {
        	System.out.println(i+"번째 회전");
    		System.out.println("n의 값 ->"+ n);
    		System.out.println("a의 값 ->"+ a);
        	if(n/a == 1 || n/a == 2) {
        		list.add(n/a);
        	}else {
        		list.add(0);
        	}
        	n %= a;
         	a /= 3;
    		System.out.println(list);
    		System.out.println("============");
        }        
        
        Collections.reverse(list);
        a=1;
        for(int i=count-1; i>=0; i--) {
        	answer += list.get(i)*a;
        	a *= 3;
        }
        return answer;
    }

}
