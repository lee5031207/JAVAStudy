package skillup.day01.inherit.parent.model.vo;

public class Person {
	
	public String name;
	public int age;
	public double height;
	public double weight;
	
	public Person() {
		
	}
	
	public Person(String name, int age, double height, double weight) {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String information() {
		return "안녕? 나는 " + name + " 이야";
	}
	
}
