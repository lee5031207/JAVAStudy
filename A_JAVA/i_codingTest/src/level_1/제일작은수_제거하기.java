package level_1;

import java.util.ArrayList;
import java.util.Collections;

public class 제일작은수_제거하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1};
		int[] answer = solution(arr);
		
		for (int i : answer) {
			System.out.print(i+" ");
		}
	}
    public static int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> sortList = new ArrayList<Integer>();
        for (Integer i : arr) {
			list.add(i);
			sortList.add(i);
		}
        Collections.sort(sortList);
       
        int small = sortList.get(0);
        int sIdx = list.indexOf(small);
        list.remove(sIdx);
        
        int[] answer = new int[list.size()];
        
        if(list.size()==0) {
        	int[] answer2 = {-1};
        	return  answer2;
        }else {
            for(int i=0; i<list.size(); i++) {
            	answer[i] = list.get(i);
            }
            return answer;
        }
    }

}
