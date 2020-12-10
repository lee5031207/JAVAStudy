package level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 체육복_탐욕법 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] lost = {3,4,5};
		int[] reserve = {3,4};

		int answer= solution(n, lost, reserve);
		System.out.println("정답 : "+answer);

	}
	public static int solution(int n, int[] lost, int[] reserve) {
		// int n : 전체학생수
		// int[] lost : 도난당한 학생번호 배열 
		// int[] reverse : 여벌의 체육복이 있는 학생 번호 배열
		
		//7번 테스트케이스에서 오류 : 여벌을 가진 사람들이 전부 도난 당하는 경우
	
		ArrayList<Integer> reserve_list = new ArrayList<Integer>();
		for(int i : reserve) {
			reserve_list.add(i);  
		}
		
		ArrayList<Integer> lost_list = new ArrayList<Integer>();
		for(int i : lost) {
			lost_list.add(i);  
		}
		
		for(int i=0; i<lost_list.size();i++) {
			if(reserve_list.contains(lost_list.get(i))) {
				reserve_list.remove((Integer)lost_list.get(i));
				lost_list.remove(i);
				i--;
			}
		}
	
		if(reserve_list.size() == 0) {
			return lost_list.size();
		}
		
		int count = 0, low,high = 0;
		for(int i=0; i<lost_list.size(); i++) {
			low = lost_list.get(i)-1;
			high = lost_list.get(i)+1;
			if(reserve_list.contains(low)) { //작은애가 여분이 있다
				//reserve_list에서 low를 없애야한다 어떻게 없애지 -> (Integer)low 이런식으로 넣으면 인덱스가 아닌 객체로 인식한단다
				reserve_list.remove((Integer)low);
				continue;
			}else if(reserve_list.contains(high)) { //큰애가 여분이 있다
				reserve_list.remove((Integer)high);
				continue;
			}else {
				count++;
				continue;
			}
		}		
		int answer = n-count;
		return answer;
		
	}


}
