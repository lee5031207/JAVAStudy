package skillup.day01.inherit.child.model.vo;

import skillup.day01.inherit.parent.model.vo.Person;

public class Employee extends Person{
	
	private int salary;
	private String dept;
	
	public Employee() {
		
	}

	public Employee(String name, int age, double height, double weight
			,int salary, String dept) {
		super(name, age, height, weight);
		this.salary = salary;
		this.dept = dept;		
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
