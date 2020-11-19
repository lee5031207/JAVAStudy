package level_1;

import java.util.ArrayList;
import java.util.Collections;

public class 두개_뽑아서_더하기 {

	public static void main(String[] args) {
		//정수 배열 numbers가 주어집니다. 
		//numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는
		//모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
		int [] numbers = new int[5];
		numbers[0] = 2;
		numbers[1] = 1;
		numbers[2] = 3;
		numbers[3] = 4;
		numbers[4] = 1;
		numbers = solution(numbers);
		System.out.println(numbers);
		for(int i=0; i<numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
	}

    public static int[] solution(int[] numbers) {
        
        //다 더한수를 넣어준다 근데, 넣을때 있는 값인지 체크한다 체크해서 있으면 안넣는다
        ArrayList<Integer> numberArr = new ArrayList<>();
        for(int i=0; i<numbers.length; i++) {
        	numberArr.add(numbers[i]);
        }
        Collections.sort(numberArr); //정렬해줌
        ArrayList<Integer> resultArr = new ArrayList<>(); //result가 들어갈 ArrayList
        int forResult = 0;
        for(int i=0; i<numberArr.size(); i++) {
        	for(int j=0; j<numberArr.size(); j++) {
        		if(i==j) {
        			continue;
        		}
        		forResult = numberArr.get(i)+numberArr.get(j);
        		if(resultArr.contains(forResult)) {
        			continue;
        		}else {
        			resultArr.add(forResult);
        		}
        	}
        }
        Collections.sort(numberArr); //정렬해줌
        int[] answer = new int[resultArr.size()];
        for(int i=0; i<resultArr.size(); i++) {
        	answer[i] = resultArr.get(i);
        }
        return answer;
        
    }
}
