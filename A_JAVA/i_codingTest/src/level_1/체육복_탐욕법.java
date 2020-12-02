package level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 체육복_탐욕법 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] lost = {1,3,5};
		int[] reserve = {1,3,4};

		int answer= solution(n, lost, reserve);
		System.out.println("정답 : "+answer);
	}
	public static int solution(int n, int[] lost, int[] reserve) {
		// int n : 전체학생수
		// int[] lost : 도난당한 학생번호 배열 
		// int[] reverse : 여벌의 체육복이 있는 학생 번호 배열
	
		//n	 lost	 reserve	participation return
		//5	 [2, 4]	 [1, 3, 5]	[1,2,3,4,5]   5
		// n크기의 Arraylist 만들고 거기에 번호 할당해준다
		// lost에서 lost[0]을 꺼낸다, lost[0]-1, 하고 lost[0]+1이  reserve에 있는지 확인한다
		// 있다면  participation을 냅두고 reserve에서 발견된 lost[0]-1 혹은 lost[0]+1을 지워준다 
		// 없다면  participation에서 lost[0] 을 없앤다.
		// -----> 이걸 반복
	
		
		ArrayList<Integer> reserve_list = new ArrayList<Integer>();
		for(int i : reserve) {
			reserve_list.add(i);  
		}
		
		ArrayList<Integer> lost_list = new ArrayList<Integer>();
		for(int i : lost) {
			lost_list.add(i);  
		}
		//두개다 Arraylist로 바꿈
		
		System.out.println(lost_list.size());
		for(int i=0; i<lost_list.size(); i++) {
			if(reserve_list.contains(lost_list.get(i))) {
				System.out.println(i+"번 회전");
				reserve_list.remove((Integer)lost[i]);
				lost_list.remove((Integer)lost[i]);
				continue;
			}
		}
		System.out.println(lost_list);
		System.out.println(reserve_list);

		int count = 0,low,high = 0;
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
