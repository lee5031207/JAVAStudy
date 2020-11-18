package com.hw3.comtroller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

import com.hw3.model.vo.Book;

public class BookManager {
	
	Scanner sc = new Scanner(System.in);
	
	public void fileSave() {
		Book[] bk = new Book[5]; //Book객체를 받을 배열
		bk[0] = new Book("C언어", "김씨", 10000, setCalendar(2012, 2, 2), 0.1);
		bk[1] = new Book("자바", "이씨", 20000, setCalendar(2013, 3, 3), 0.2);
		bk[2] = new Book("C++", "박씨", 30000, setCalendar(2014, 4, 4), 0.3);
		bk[3] = new Book("넛지", "서씨", 40000, setCalendar(2015, 5, 5), 0.4);
		bk[4] = new Book("개미", "최씨", 50000, setCalendar(2016, 6, 6), 0.5);
		
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.dat"))){			
			oos.writeObject(bk);
			System.out.println("books.dat 파일 생성 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Calendar setCalendar(int year,int month, int date) {
		Calendar result = Calendar.getInstance();
		result.set(year, month, date);		
		return result;		
	}
	
	public void fileRead() {
		Book[] readBook = new Book[10];
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.dat"))) {
				readBook = (Book[])ois.readObject();
				for (Book book : readBook) {
					System.out.println(book.toString());
				}
		} catch (EOFException e) {
			System.out.println("books.dat 읽기완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
