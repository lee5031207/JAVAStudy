package com.kh.c_prac;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.kh.c_prac.model.vo.Music;

public class MusicDatMaker {
	//music.dat 파일을 만들면 되는듯?
	
	public static void main(String[] args) {
		
		Music favorite = new Music("김경호", "나를 슬프게 하는 사람들");
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("music.dat"))){
			oos.writeObject(favorite);
			oos.flush();
			System.out.println("music.dat 생성 완료!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
