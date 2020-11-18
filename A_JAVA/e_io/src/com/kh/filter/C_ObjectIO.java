package com.kh.filter;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.filter.model.vo.Phone;
import com.kh.filter.model.vo.Student;
import com.kh.filter.model.vo.Teacher;

public class C_ObjectIO {
	
	public void objectOutPut() {
		Phone phone = new Phone("삼성", 70);
		Student student = new Student("이성욱",'M',phone);
		Teacher teacher = new Teacher("P","하명도");
		
		try(ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream("student.dat"))){
			
			oos.writeObject(phone);
			oos.writeObject(student);
			oos.writeObject(teacher);
			
			System.out.println("Student.dat.파일 생성 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//EOFException(end of file Exception)
	//파일에서 더이상 읽을게 없으면 발생하는 예외.
	//이 예외가 발생했다는 것은 모든 데이터를 다 읽었다는 의미
	//catch블록에 후속 코드를 작성
	public void objectInput() {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"))){
			
			//계속 반복하면 dat파일에 들어있는 데이터를 읽어온다
			while(true) {
				//ObjectInputStream이 모든 데이터를 읽으면
				//EOFException 방생 -> 해당 catch블록으로 이동
				Object res = ois.readObject();
				System.out.println(res);
			}
		} catch (EOFException e) {
			System.out.println("모든 객체를 출력하였습니다.");
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
