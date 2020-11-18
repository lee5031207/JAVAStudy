package com.kh.b_throw;

public class ThrowsTest {

	//throws : 예외 상황이 발생하였을 대 해당 예외에 대한 처리를
	//		    메서드를 호출한 대상에게 넘길 수 있다.
	
	public static void main(String[] args) {
		new ThrowsTest().testA();
	}
	public void testA() {
		try {
			testB();
			testC();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
	}
	//NullPointerException
	public void testB() throws NullPointerException{		
		String name = null;
		name.length();
		System.out.println("호출한 메서드에게 돌려보낸다.");
		
	}
	//ArrayindexOudOfBoundsException
	public void testC() throws ArrayIndexOutOfBoundsException{
		String[] strArr = {"a","b"};
		strArr[2] = "c";
	}
}
