package skillup.day03.library.model.vo;

public class Book {

	protected String title; //도서명
	protected String author; //저자
	protected String publisher; //출판사명
	
	public Book() {
	
	}
	public Book(String title,String author,String publisher) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + "]";
	}
	
	
	
	
	
}