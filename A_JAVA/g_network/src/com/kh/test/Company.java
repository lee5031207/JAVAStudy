package com.kh.test;

public class Company {

	
	private String name;
	private int numOfEmp;
	
	public Company() {
		
	}
	
	public Company(String name, int numOfEmp) {
		super();
		this.name = name;
		this.numOfEmp = numOfEmp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfEmp() {
		return numOfEmp;
	}

	public void setNumOfEmp(int numOfEmp) {
		this.numOfEmp = numOfEmp;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", numOfEmp=" + numOfEmp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numOfEmp;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numOfEmp != other.numOfEmp)
			return false;
		return true;
	}

	
	
}
