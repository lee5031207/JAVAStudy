package factory;

import java.util.Date;

public class Run {

	public static void main(String[] args) {
		
		ConnectorFactory cf = ConnectorFactory.builder()
				.id("lee5031207")
				.password("1234")
				.url("lee5031207@naver.com")
				.build();
		
		SMTPConnector gmail = cf.getConnector("google");
		
		System.out.println(gmail);
		gmail.connect();
		
	}
}
