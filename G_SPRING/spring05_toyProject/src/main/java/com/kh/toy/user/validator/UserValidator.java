package com.kh.toy.user.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.kh.toy.user.model.Repository.UserRespository;
import com.kh.toy.user.model.vo.User;

@Component
public class UserValidator implements Validator{

	private final UserRespository userRepository;

	public UserValidator(UserRespository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User) target;
		
		//1. 아이디 존재 유무
		if(userRepository.selectUserforAuth(user) != null) {
			errors.rejectValue("userId", "error.userId", "이미 존재하는 아이디 입니다");
		}
		//2. 비밀번호가 8글자 이상의 숫자 영문자, 특수문자 조합인지
		Pattern pattern = Pattern.compile("^(?!.*[ㄱ-힣])(?=.*\\W)(?=.*\\d)(?=.*[a-zA-Z])(?=.{8,})");
		if(!pattern.matcher(user.getUserPw()).find()) {
			errors.rejectValue("password", "error.password", "비밀번호는 영어,숫자,특수문자 조합의 8자 이상입니다.");
		}
		//3. 이메일 존재 유무
		if(userRepository.selectUserByEmail(user.getUserEmail()) > 0) {
			errors.rejectValue("email", "error.email", "이미 존재하는 이메일 입니다");
		}
		//4. 휴대폰 번호 존재 유뮤
		if(userRepository.selectUserByTell(user.getUserPhone()) > 0) {
			errors.rejectValue("tell", "error.tell", "이미 존재하는 휴대폰 번호 입니다");
		}

	}

}
