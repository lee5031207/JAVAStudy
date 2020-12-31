package 강사님;

import java.util.ArrayList;
import java.util.Collections;

public class 로또 {

	public static void main(String[] args) {
		lotto();
	}
	
	public static int[] lotto() {
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		int no = 0;
		for(int i=0; i<6; i++) {
			no = (int)(Math.random()*45) + 1;
			if(!resultList.contains(no)) {
				resultList.add(no);
			}else {
				i--;
			}
			Collections.sort(resultList);
		}
		System.out.println(resultList);
		return null;
		
	}

}
