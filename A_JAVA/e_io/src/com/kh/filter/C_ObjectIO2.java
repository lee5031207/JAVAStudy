package com.kh.filter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kh.filter.model.vo.Phone;
import com.kh.filter.model.vo.Student;
import com.kh.filter.model.vo.Teacher;

public class C_ObjectIO2 {

	Scanner sc = new Scanner(System.in);
	
	public void objectOutput() {
		List<Phone> phoneList = new ArrayList<>();
		List<Student> studentList = new ArrayList<>();
		List<Teacher> teacherList = new ArrayList<>();
		
		phoneList.add(new Phone("삼성", 700000));
		phoneList.add(new Phone("애플", 1200000));
		phoneList.add(new Phone("LG", 500000));
		
		studentList.add(new Student("이성욱", 'M', phoneList.get(1)));
		studentList.add(new Student("이승현", 'M', phoneList.get(0)));
		studentList.add(new Student("사보현", 'F', phoneList.get(1)));
		studentList.add(new Student("함동희", 'M', phoneList.get(2)));
		
		teacherList.add(new Teacher("P", "하명도"));
		teacherList.add(new Teacher("Q", "이동헌"));
		teacherList.add(new Teacher("S", "이창진"));
		
		Map<String,Object> commandMap = new HashMap<>();
		commandMap.put("phone",phoneList);
		commandMap.put("student",studentList);
		commandMap.put("teacher",teacherList);
		
		try(ObjectOutputStream oos
				= new ObjectOutputStream(new FileOutputStream("student2.dat"))){
			
			oos.writeObject(commandMap);
			System.out.println("student2.dat 파일 생성 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void objectInput() {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream("student2.dat"))){
			
			Map<String,Object> commanMap 
				= (Map<String, Object>) ois.readObject();
				
			//학생 데이터가 궁금하다 ?
			List<Student> students = (List<Student>) commanMap.get("student");
			for(Student st : students) {
				System.out.println(st);
			}
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
