package level_1;

import java.util.ArrayList;
import java.util.Collections;

public class 비밀지도 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] arr1 = {9,20,28,18,11};
		int[] arr2 = {30,1,21,17,28};
		int[] arr3 = {46,33,33,22,31,50};
		int[] arr4 = {27,56,19,14,14,10};
		String[] answer = solution2(n, arr1, arr2);



	}
	
	// 1.[이진수 변환 직접 한거]
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        //1. arr1, arr2를 이진수로 바꿔야함
        ArrayList<Integer> impl = new ArrayList<Integer>();
        ArrayList<Boolean> line2 = new ArrayList<Boolean>();
        boolean[][] arr1Answer = new boolean[n][n];
        boolean[][] arr2Answer = new boolean[n][n];
        
        //1-1. arr1을 2진수로 바꿔서 정답배열로 바꿈
        int x = 0;
        for(int i=0; i<n; i++) {
        	x = arr1[i];
        	for(int k=arr1[i]; k>0; k--) {
        		if(confirmSqrt(k)) {
        			impl.add(confirmSqrt2(k));
        			k = x-k;
        			x = k;
        			k++;
        		}
        	}
        	for(int j=0; j<n; j++) {
        		line2.add(false);
        	}
        	for (Integer num : impl) {
        		line2.set(num, true);
			}
        	Collections.reverse(line2);
        	for(int y=0; y<line2.size(); y++) {
        		arr1Answer[i][y] = line2.get(y);
        	}
        	line2.clear();
        	impl.clear();
        }
        
        //1-2. arr2을 2진수로 바꿔서 정답배열로 바꿈
        int y = 0;
        for(int i=0; i<n; i++) {
        	y = arr2[i];
        	for(int k=arr2[i]; k>0; k--) {
        		if(confirmSqrt(k)) {
        			impl.add(confirmSqrt2(k));
        			k = y-k;
        			y = k;
        			k++;
        		}
        	}
        	for(int j=0; j<n; j++) {
        		line2.add(false);
        	}
        	for (Integer num : impl) {
        		line2.set(num, true);
			}
        	Collections.reverse(line2);
        	for(int z=0; z<line2.size(); z++) {
        		arr2Answer[i][z] = line2.get(z);
        	}
        	line2.clear();
        	impl.clear();
        }
        
        //2. 나온 정답배열 2개를 가지고 진짜 정답배열을 만들어냄
        String answerLine = "";
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(arr1Answer[i][j] || arr2Answer[i][j]) {
        			answerLine = answerLine+"#"; 
        		}else {
        			answerLine = answerLine+" ";
        		}
        	}
        	answer[i] = answerLine;
        	answerLine = "";
        }
        return answer;
    }
    
    //2의 제곱근인지 확인하는 메서드
    public static boolean confirmSqrt(int i) {
    	while(true) {
			if(i%2!=0 || i/2 ==1) {
				break;
			}else{
				i = i/2;
			}
		}
    	if(i==2 || i==1) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    //2의제곱근 x가 2의 몇승인지 확인하는 메서드
    public static int confirmSqrt2(int x) {
    	int cnt = 0;
    	if(x==1) {
    		return 0;
    	}else {
    		while(true) {
        		cnt++;
        		if(x/2 == 1) {
        			break;
        		}else{
        			x = x/2;
        		}
        	}
    	}
		return cnt;
    }

    // 2.[이진수 변환 메서드 활용]
    public static String[] solution2(int n, int[] arr1, int[] arr2) {
      	String[] answer = new String[n];
       	String[] binaryArr1 = new String[n];
       	String[] binaryArr2 = new String[n];
       	 
       	boolean[][] booleanArr1 = new boolean[n][n];
       	boolean[][] booleanArr2 = new boolean[n][n];
       	int blankCnt;
       	for(int i=0; i<n; i++) {
       		// 2진수 변환
       		binaryArr1[i] = Integer.toBinaryString(arr1[i]);
       		binaryArr2[i] = Integer.toBinaryString(arr2[i]);
       		
       		//자리수 맞추기
       		blankCnt = 0;
       		if(binaryArr1[i].length() < n) {
       			blankCnt = n-binaryArr1[i].length();
       			for(int j=0; j<blankCnt; j++) {
       				binaryArr1[i] = "0"+binaryArr1[i];
       			}
       		}
       		if(binaryArr2[i].length() < n) {
       			blankCnt = n-binaryArr2[i].length();
       			for(int j=0; j<blankCnt; j++) {
       				binaryArr2[i] = "0"+binaryArr2[i];
       			}
       		}
       		
       		// OR연산할 수 있도록
       		for(int j=0; j<n; j++) {
       			if(binaryArr1[i].charAt(j) == '1') {
       				booleanArr1[i][j] = true;
       			}else if(binaryArr1[i].charAt(j) == '0') {
       				booleanArr1[i][j] = false;
       			}
       			if(binaryArr2[i].charAt(j) == '1') {
       				booleanArr2[i][j] = true;
       			}else if(binaryArr1[i].charAt(j) == '0') {
       				booleanArr2[i][j] = false;
       			}
       			
       		}
       	}
   		//이제 OR연산해서 값뽑자
   		String answerLine = "";
        for(int x=0; x<n; x++) {
        	for(int y=0; y<n; y++) {
        		if(booleanArr1[x][y] || booleanArr2[x][y]) {
        			answerLine = answerLine+"#";
        		}else {
        			answerLine = answerLine+" ";
        		}
        	}
        	answer[x] = answerLine;
        	answerLine = "";
        }
       	return answer;
    }
}
