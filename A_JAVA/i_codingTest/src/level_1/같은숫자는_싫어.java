package level_1;

import java.util.*;

public class 같은숫자는_싫어 {

	public static void main(String[] args) {
		
		int[] arr = {1,1,3,3,0,1,1};
		solution(arr);
	}
	
	public static int[] solution(int []arr) {
		int count = 0;
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] == arr[i+1]) {
				arr[i] = 10;
				count++;
			}
		}
		int[] answer = new int[arr.length-count];
		int cnt = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]!=10) {
				answer[i-cnt] = arr[i];
			}else {
				cnt++;
			}
		}
		return answer;
    }
}
