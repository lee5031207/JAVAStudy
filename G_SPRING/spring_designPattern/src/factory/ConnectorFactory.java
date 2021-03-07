package factory;

import java.util.Date;

// Factory패턴
// 장점 1: 인스턴스를 생성하는 코드가 한곳에 모여있다.
//			인스턴스를 생성하기 위한 코드가 변경되었을 때
//			인스턴스를 생성하는 코드는 Factory 클래스에만 있으므로 
// 장점 2: 사용자에게 최소한의 정보만 입력받은 뒤 추가적인 속성들은 내부에서 초기화 하여 인스턴스 생성

public class ConnectorFactory {

	private String url;
	private String id;
	private String password;
	private Date connectTime;
	
	public ConnectorFactory(ConnectFactoryBuilder builder) {
		super();
		this.url = builder.url;
		this.id = builder.id;
		this.password = builder.password;
		this.connectTime = new Date();
	}
	public static ConnectFactoryBuilder builder() {
		return new ConnectFactoryBuilder();
	}
	
	public static class ConnectFactoryBuilder{
		
		private String url;
		private String id;
		private String password;
		private Date connectTime;
		
		public ConnectFactoryBuilder url(String val) {
			this.url = val;
			return this;
		}
		public ConnectFactoryBuilder id(String val) {
			this.id = val;
			return this;
		}
		public ConnectFactoryBuilder password(String val) {
			this.password = val;
			return this;
		}
		public ConnectFactoryBuilder connectTime(Date val) {
			this.connectTime = val;
			return this;
		}
		public ConnectorFactory build() {
			return new ConnectorFactory(this);
		}
		
	}
	
	
	public SMTPConnector getConnector(String mailName) {
		
		if(mailName.equalsIgnoreCase("google")) {
			return new GoogleMail(url, id, password, connectTime);
		}else if(mailName.equalsIgnoreCase("naver")) {
			return new NaverMail(url, id, password, connectTime);
		}else if(mailName.equalsIgnoreCase("daum")) {
			return new DaumMail(url, id, password, connectTime);
		}else {
			System.out.println("잘못된 메일 서버 이름을 입력하셨습니다.");
			return null;
		}
		
	}

}
