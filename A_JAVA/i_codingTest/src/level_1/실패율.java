package level_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 실패율 {

	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2,1,2,6,2,4,3,3};
		int N2 =4;
		int[] stages2 = {4,4,4,4,4};
		int[] answer = solution(N2, stages2);
		for (int i : answer) {
			System.out.print(i);
		}
	}
	
    public static int[] solution(int N, int[] stages) {
    	
        int[] answer = new int[N];

        //1. 스테이지에 도달한 플레이어 수
        //2. 스테이지에 도달했으나 아직 클리어 못한 플레이어 수
        //     1스테이지 도달한 수 -> stages에서 1이상인 숫자의 개수 / 1스테이지 클리어 못한 수 -> stages에서 1의 개수
        //3. 각 스테이지 별 실패율 맵에 저장
        
        Map<Integer, Integer> reachStageCnt = new HashMap<Integer, Integer>();
        Map<Integer, Integer> notClearCnt = new HashMap<Integer, Integer>();
        ArrayList<Double> failureRate = new ArrayList<Double>();
        ArrayList<Double> sortFailureRate = new ArrayList<Double>();
        for(int i=1; i<N+1; i++) {
        	reachStageCnt.put(i, 0);
        	notClearCnt.put(i, 0);
        	for(int j=0; j<stages.length; j++) {
        		if(stages[j]>=i) {
        			reachStageCnt.put(i, reachStageCnt.get(i)+1);
        		}
        		if(stages[j]==i) {
        			notClearCnt.put(i, notClearCnt.get(i)+1);
        		}
        	}
        	if(notClearCnt.get(i)==0 && reachStageCnt.get(i)==0) {
        		failureRate.add((double) 0);
        		sortFailureRate.add((double) 0);
        	}else {
        		failureRate.add((double)notClearCnt.get(i)/(double)reachStageCnt.get(i));
            	sortFailureRate.add((double)notClearCnt.get(i)/(double)reachStageCnt.get(i));
        	}
        }
        Collections.sort(sortFailureRate);
        Collections.reverse(sortFailureRate);
     
        for(int i=0; i<failureRate.size(); i++) {
        	answer[i] = failureRate.indexOf(sortFailureRate.get(i))+1;
        	failureRate.set(failureRate.indexOf(sortFailureRate.get(i)), (double) -1);
        }
        return answer;
    }
    

}
