package com.kh.test;

import java.util.HashMap;

public class test3 {

	public void fileSave(){
		
		HashMap<Integer, Food> flist = new HashMap();
		
		flist.put(1, new Food("사과", 20));
		flist.put(2, new Food("바나나", 30));
		flist.put(3, new Food("토마토", 15));
		
	}
}
