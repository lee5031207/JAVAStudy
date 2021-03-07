package builder;

public class Book {

	private String title;
	private String author;
	private String publisher;
	private int page;
	
	//객체 생성 패턴
	//1. 점층적 생성자 패턴
	//   생성자의 매개변수를 통해 객체의 속성을 초기화 하고 생성하는 패턴
	//   단점 : 코드만 보고 생성자의 매개 변수로 전달받는 인자가 어떤 속성에 전달되는 인자인지 파악하기 힘듬	
	
	//2. 자바 빈 패턴
	//   getter/setter
	//   단점 : setter메서드를 사용하기 때문에 객체를 변경 불가능한 객체로 만들 수 없다.
	//   스레드 세이프한 객체를 만들기 위해 점층적 생성자 패턴보다 더 많은 일을 해야한다.
	
	//3. 빌더 패턴
	//외부로부터 속성값을 전달받아 Outer Class의 생성자를 호출하는 클래스
	
	public Book() {
		
	}
	
	private Book(BookBuilder builder) {
		super();
		this.title = builder.title;
		this.author = builder.author;
		this.publisher = builder.publisher;
		this.page = builder.page;
	}
	
	public static BookBuilder builder() {
		return new BookBuilder();
	}
	
	public static class BookBuilder{

		private String title;
		private String author;
		private String publisher;
		private int page;
		
		public BookBuilder title(String val) {
			this.title = val;
			return this;
		}
		
		public BookBuilder author(String val) {
			this.author = val;
			return this;
		}
		
		public BookBuilder publisher(String val) {
			this.publisher = val;
			return this;
		}
		
		public BookBuilder page(int val) {
			this.page = val;
			return this;
		}
		
		public Book build() {
			return new Book(this);
		}
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + ", page=" + page + "]";
	}
	
}
