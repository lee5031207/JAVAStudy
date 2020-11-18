package com.kh.training.model.vo;

public class Trainee {

	private String name;
	private char classRoom;
	private int score;
	
	public Trainee() {
		
	}
	public Trainee(String name, char classRoom, int score) {
		this.name = name;
		this.classRoom = classRoom;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(char classRoom) {
		this.classRoom = classRoom;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public String inform() {
		
		return name+"/"+classRoom+"/"+score;
	}
	
	
}
