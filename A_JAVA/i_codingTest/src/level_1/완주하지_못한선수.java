package level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 완주하지_못한선수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
		//마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
		//완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
		String[] participant = new String[3];
		String[] completion = new String[participant.length-1];
		participant[0] = "leo";
		participant[1] = "kiki";
		participant[2] = "eden";
		
		completion[0] = "eden";
		completion[1] = "kiki";
		
		
		String answer = solution(participant, completion);
		System.out.println(answer);
	}
	public static String solution(String[] participant, String[] completion) {
		
		String answer = "";
		
		//두개 배열 모두 ArrayList로 바꿈
		ArrayList<String> participantArr = new ArrayList<String>(Arrays.asList(participant));
		ArrayList<String> completionArr = new ArrayList<String>(Arrays.asList(completion));
//		for(int i=0; i<participant.length; i++) {
//			participantArr.add(participant[i]);
//		}
//		for(int i=0; i<completion.length; i++) {
//			completionArr.add(completion[i]);
//		}
		
		Collections.sort(participantArr);
		Collections.sort(completionArr);
		System.out.println(participantArr);
		System.out.println(completionArr);

		//비교를하자 두개를 만약 두개의 인덱스가 같은 값이면 두개를 삭제하고 i의 값을 -1하자
		//비교가 다끝나면 남은 participantArr[0]의 값이 이제 완주하지 못한 선수
		//중간에 동명이인 : 두개 비교하다 다른 값이 면은 그놈이 동명이인 participantArr
		for(int i=0; i<completionArr.size(); i++) {
			if(participantArr.get(i).equals(completionArr.get(i))) {
				//participantArr.remove(i);  //remove하면 한칸씩 앞으로 온다 값들이 
				//completionArr.remove(i);   //그래서 i에 -1 해주어여함
				//i -= 1;
				continue;
			}else {
				answer = participantArr.get(i);
				return answer;
			}
		}
		answer = participantArr.get(completion.length);        
        return answer;
        
	}

}
