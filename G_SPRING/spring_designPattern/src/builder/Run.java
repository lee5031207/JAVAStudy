package builder;

public class Run {
	
	public static void main(String[] args) {

		Book book = Book.builder().title("홍길동").author("김애란").publisher("신사임당").page(1000).build();
		int result = new Calculator().add(5).add(3).subtract(3).out();
		
		System.out.println(result);
	}
	
}
