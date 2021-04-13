package com.kh.toy.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

//가상으로 만들어지는 web.xml을 사용해 테스트환경을 구축
@WebAppConfiguration
//Junit 단위 테스트 프레임워크의 실행 방법을 지정
//테스트 때 사용할 가상의 applicationContext를 생성하고 관리해준다. 
@RunWith(SpringJUnit4ClassRunner.class)
//가상 applicationContext를 생성할 때 사용한 Spring bean 설정파일의 위치를 지정     
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"}) //spring/모든폴더/context.xml로 끝나는 모든 파일
public class UserControllerTest {

	@Autowired
	WebApplicationContext context;

	private MockMvc mockMvc;
	
	//테스트를 수행하기 전에 실행할 메서드
	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(context).build();
	}
	
	@Test
	public void authEmailTest() throws Exception{
		mockMvc
		.perform(post("/user/mailauth")
				.param("userId", "testUser")
				.param("userPw", "yoo403010#")
				.param("userEmail", "lee5031207@naver.com")
				.param("userPhone", "01074861207"))

		.andDo(print());
	}
}
