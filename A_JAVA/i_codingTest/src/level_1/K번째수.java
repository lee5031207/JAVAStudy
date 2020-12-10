package level_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class K번째수 {
	
	public static void main(String[] args) {
		
		
		int [] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] answer = solution(array, commands);
		
	}
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        //예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
        //array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
        //1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
        //2에서 나온 배열의 3번째 숫자는 5입니다.
        int i,j,k = 0;

        for(int a=0; a<commands.length; a++) {
        	i=commands[a][0]-1;  //시작 위치
        	j=commands[a][1];  //끝 위치
        	k=commands[a][2];  //인덱스 번호
        	
        	List<Integer> res = new ArrayList<Integer>();
        	for(int b=i; b<j; b++) {
        		res.add(array[b]);
        	}   	
        	Collections.sort(res);
        	answer[a] = res.get(k-1);
        }
        return answer;
    }
    
    
}
