package level_1;

public class 키패드_누르기3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1,3,4,5,8,2,1,4,5,9,5};
		int[] numbers2 = {7,0,8,2,8,3,1,5,7,6,2};
		int[] numbers3 = {1,2,3,4,5,6,7,8,9,0};
		String hand = "right";
		System.out.println(solution(numbers, hand));
		System.out.println("LRLLLRLLRRL");
	}
	
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        
        // char[4][3] 형태의 keyPad 배열 선언 
        int[][] keyPad = new int[4][3];
        int num = 1;
        for(int i=0; i<3; i++) {
        	for(int j=0; j<3; j++) {
        		keyPad[i][j] = num;
        		num++;
        	}
        }
        keyPad[3][0] = 30; 
        keyPad[3][1] = 0;
        keyPad[3][2] = 32;

        
        // 왼손, 오른손 시작 위치 초기화
        int left = 30, right = 32;
     
        int[] leftLoc = new int[2];
        int[] rightLoc = new int[2];
        int[] numLoc = new int[2];
        
        //숫자 누르기 시작
        for(int i=0; i<numbers.length; i++) {
    		//System.out.println("========number["+i+"]========");
    		//System.out.println("left : "+left+" / right : "+right+" / 눌러야 하는 숫자 : "+numbers[i]);
        	if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
        		//숫자가 1,4,7 이면 answer에 L넣고, 왼손 위치 변경
        		answer += 'L';
        		left = numbers[i];
        		
        	}else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
        		//숫자가 3,6,9 이면 answer에 L넣고, 왼손 위치 변경
        		answer += 'R';
        		right = numbers[i];
        	}else {
        		leftLoc = new int[2];
        		rightLoc = new int[2];
        		numLoc = new int[2];
        		
        		//중간 라인 가까운 손으로 누른다
        		//System.out.println("========number["+i+"]========");
        		//System.out.println("left : "+left+" / right : "+right+" / 눌러야 하는 숫자 : "+numbers[i]);
        		for(int j=0; j<4; j++) {
        			for(int k=0; k<3; k++) {
        				if(keyPad[j][k] == left) {
        					leftLoc[0] = j;
        					leftLoc[1] = k;
        				}
        				if(keyPad[j][k] == right) {
        					rightLoc[0] = j;
        					rightLoc[1] = k;
        				}
        				if(keyPad[j][k] == numbers[i]) {
        					numLoc[0] = j;
        					numLoc[1] = k;
        				}
        			}
        		}
        		//System.out.println("leftLoc : ["+leftLoc[0]+","+leftLoc[1]+"] / rightLoc : ["+rightLoc[0]+","+rightLoc[1]+"] / numLoc : ["+numLoc[0]+","+numLoc[1]+"]");
        		//System.out.println("");
        		//이제 왼손 위치 , 오른손 위치, 눌러여할 숫자 위치를 다구함
        		if(distance(leftLoc, numLoc) < distance(rightLoc, numLoc)) {
        			//오른손이 더 멀다면 왼손
        			left = numbers[i];
        			answer += 'L';
        		}else if(distance(leftLoc, numLoc) > distance(rightLoc, numLoc)) {
        			//왼손이 더 멀다면 오른손
        			right = numbers[i];
        			answer += 'R';
        		}else if(distance(leftLoc, numLoc) == distance(rightLoc, numLoc)) {
        			if(hand == "left") {
        				left = numbers[i];
        				answer += 'L';
        			}else if(hand == "right") {
        				right = numbers[i];
        				answer += 'R';
        			}
        		}
        	}
        	//System.out.println("left : "+left+" / right : "+right);
        }
        return answer;
    }
    
    public static int distance(int[] handLoc, int[] numLoc) {
    	return Math.abs(handLoc[0]-numLoc[0])+Math.abs(handLoc[1]-numLoc[1]);
    }

}
