package aop04;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Developer{

	@Override
	public String develop(String lang) {
		System.out.println(lang + " 프로그래밍 시작한다.");
		return lang + " 프로그래밍 시작한다.";
	}

	@Override
	public String play(String game) {
		System.out.println(game + "를 하고 논다.");
		return game + "를 하고 논다.";
	}
}
