package com.kh.toy.board;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"}) 
public class BoardControllerTest {

	@Autowired
	WebApplicationContext context;

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(context).build();
	}
	
	@Test
	public void selectBoardListTest() throws Exception{
		mockMvc.perform(get("/board/list"))
		.andDo(print());
	}
	
	@Test
	public void uploadBoardTest() throws Exception {

		MockMultipartFile file1 = new MockMultipartFile("files", "OFN.txt", null, "firstFile".getBytes());
		MockMultipartFile file2 = new MockMultipartFile("files", "OFN2.txt", null, "secondFile".getBytes());
		mockMvc.perform(multipart("/board/upload")
				.file(file1)
				.file(file2)
				.contentType(MediaType.MULTIPART_FORM_DATA)
				.param("title", "게시글 테스트")
				.param("content", "목객체를 사용한 게시글 테스트 입니다."))
		.andDo(print());
		
	}
}
