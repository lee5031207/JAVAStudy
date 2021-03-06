package com.kh.c_collection.silsub2.model.vo;

public class Book implements Comparable<Book>{

	private String bNo;  //도서번호
	private int category; //장르 분류 번호
	private String title; //도서 제목
	private String author; //도서 저자
	
	public Book() {
		//기본 생성자
	}

	public Book(int category, String title, String author) {
		super();
		this.category = category;
		this.title = title;
		this.author = author;
	}

	public String getbNo() {
		return bNo;
	}

	public void setbNo(String bNo) {
		this.bNo = bNo;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		//필드 값 문자열 합친 후 리턴 category 분류 별로 출력
		//>> 1 : 인문 / 2 : 자연과학
		//   3 : 의료 / 4 : 기타

		String categoryStr = " ";
		switch(category) {
		case 1 : categoryStr = "인문";
		case 2 : categoryStr = "자연과학";
		case 3 : categoryStr = "의료";
		case 4 : categoryStr = "기타";
		}
		return "Book [bNo=" + bNo + ", category=" + categoryStr + ", title=" + title + ", author=" + author + "]";
	}

	@Override
	public int compareTo(Book o) {
		return this.title.compareTo(o.getTitle());
		//return this.bNo.compareTo(bNo);
	}
}
