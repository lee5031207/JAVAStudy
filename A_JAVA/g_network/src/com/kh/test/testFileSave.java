package com.kh.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class testFileSave {

	public void fileSave(String fileName) {
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		File file = new File(fileName);
		try {
			
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			Food food = new Food("사과", 20);
			oos.writeObject(food);
			oos.flush();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
