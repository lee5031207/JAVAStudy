package skillup.day01.inherit.child.model.vo;

import skillup.day01.inherit.parent.model.vo.Person;

public class Student extends Person {
	
	private int grade;
	private String major;
	
	public Student() {
		
	}

	public Student(String name, int age, double height, double weight
			,int grade, String Major) {
		super(name, age, height, weight);
		this.grade = grade;
		this.major = major;
		// TODO Auto-generated constructor stub
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	

	
	
	
	
	
}
