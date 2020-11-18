package com.kh.e_inheritance.override;

//override
//오버라이드 : 자식클래스가 상속받은 부모클래스의 메서드를 재정의 하는것
//         부모가 제공하는 기능을 자식이 일부 고쳐서 사용하겠다느 의미

//오버라이드 성립 조건 : 메서드명, 매게변수, 반환형이 일치 해야함
//               접근 제한자는 부모의 것과 같거나 더 넓은 범위로 변경 

public class Book {
	//모든 클래스는  Object 클래스의 자식이다
	//Object 클래스로부터 상속 받은 메서드를 override해보자
	
	private String title;
	private String author;
	private int price;
	
	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		// TODO Auto-generated constructor stub
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

	@Override 
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}

	@Override
	public boolean equals(Object obj) {
		//객체의 주소가 같으면 같은 객체라 판단
		if (this == obj)
			return true;
		//매게변수로 넘어온 레퍼런스가  null이면 다른 객체라 판단
		if (obj == null)
			return false;
		// getClass() : 클레스의 메타데이터를 가지고 있는 Class객체를 반환해주는 메서드
		// 이 인스턴스의 클래스와 매게변수로 넘어온 클래스가 다르면  fasle
		if (getClass() != obj.getClass())
			return false;
		
		Book other = (Book) obj;
		
		//인스턴스의 author null이면
		if (author == null) {			
			if (other.author != null)
				// 매게변수 author이  null이 아니면 두인스턴스의 author 속성이 다르므로 false
				return false;
			
		} else if (!author.equals(other.author))
			return false;
		
		if (price != other.price)
			return false;
		
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		//해싱 : 어떠한 값을 일정한 자리수의 값으로 변환하는 것을 해싱이라 한다.
		//해쉬 함수 : 해싱을 위한 연산 처리를 해주느 함수 들
		// 1. 같은 값을 넣으면 언제나 같은 해싱값이 나와야한다.
		// 2. 다른 값을 넣으면 언제나 다른 값이 나와야 한다.
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + price;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	
	
	
	
	
	
}
