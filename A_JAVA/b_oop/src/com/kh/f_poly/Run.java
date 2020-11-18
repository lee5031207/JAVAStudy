package com.kh.f_poly;

public class Run {

	//다형성 : 하나의 인스턴스를 여러 타입으로 다루는 것
	//		 상속을 통해서 타입을 물려받기 때문. *****
	//		 상속을 통해서 물려받는 것 -> 필드변수, 메서드, 타입*****
	
	// * 타입에는 메서드 선언부가 담겨있다.
	//	 부모타입의 레퍼런스로 인스턴스를 다룰 경우, 부모타입에 담겨있는 메서드 선언부만 사용이 가능해서
	//	 부모 클래스에 작성되어있는 메서드만 호출이 가능해진다.
	public static void main(String[] args) {
		
		Product product = new Product("삼성", "청소기", 50000);
		//Product 클래스의 인스턴스를 Object 타입의 레퍼런스에 담을 수 있다!
		//Product 클래스가 Object 클래스를 상속받기 때문.
		Object obj = product;
		
		//부모타입의 레퍼런스로 자식 클래스 생성
		Product lgTv = new Tv("LG", "LG티비", 350000, 46);
		
		//부모타입-> 자식타입으로 캐스팅 : down casting
		//자식타입-> 부모타입으로 캐스팅 : up casting
		Tv casedTv = (Tv) lgTv;
	
		Product galaxy = new SmartPhone("애플", "아이폰", 1300000, "ios", 8, "KT");
		Computer castdownGalaxy = (Computer)galaxy;
		
		castdownGalaxy.powerOn();
		
		Desktop desktop = new Desktop("한성", "tfx245", 800000, "i5", 8, true);
		
		Computer[] computers = {castdownGalaxy, desktop};
		
		for(int i=0; i<computers.length; i++) {
			computers[i].powerOff();
		}
		
		Product[] products = {lgTv,castdownGalaxy,desktop};
		
		for(int i=0; i<products.length; i++) {
			System.out.println(products[i].getpName());
			if(products[i] instanceof Computer) {
				//다운 캐스팅을 통해 Computer타입으로 변경
				//Power on 메서드 호출
				((Computer)products[i]).powerOn();
				
			}
		}
		
		//모든 클래스의 부모인 Object를 토앻 어떤 종류의 타입의 인스턴스 이든
		//담을수 있는 만능 배열을 만들 수 있다.
		
		
		
	}
}
