package com.kh.toy.kakao.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.kh.toy.common.util.http.HttpUtil;


@WebServlet("/Kakao/*")
public class KakaoController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	HttpUtil httpUtil = new HttpUtil();
       
    public KakaoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		switch (uriArr[uriArr.length-1]) {
		case  "oauth" :
			kakaoOauth(request, response);
			break;
		default:
			response.setStatus(404);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void kakaoOauth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		String url = "https://kauth.kakao.com/oauth/token";
		Map<String, String> headers = new HashMap();
		String body = "grant_type=authorization_code&client_id=8a92e5d7d3324acd050fd30b648b921b&redirect_uri=http://localhost:9090/Kakao/oauth&code="+code;
		String result = httpUtil.post(url, headers, body);
		//System.out.println(result);
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = mapper.readValue(result, Map.class);
		//System.out.println(map);
		
		String accessToken = map.get("access_token");
		String refreshToken = map.get("refresh_token");
		
		
		String url2 = "https://kapi.kakao.com/v2/user/me";
		Map<String, String> headers2 = new HashMap<String, String>();
		headers2.put("Authorization", "Bearer "+accessToken);
		String result2 = httpUtil.get(url2, headers2);
		
		JSONParser jsonparse = new JSONParser();
		JSONObject obj;
		
		try {
			obj = (JSONObject) jsonparse.parse(result2);
			Map<String, Object> res = new HashMap<String, Object>();
			res = mapper.convertValue(obj, Map.class);
			
			//1. 카카오 회원번호 구함(기본키)
			Long kakaoId = (Long) res.get("id");
			
			//2. 이메일
			Map<String, Object> kakaoAccount = new HashMap<String, Object>();
			kakaoAccount = mapper.convertValue(res.get("kakao_account"), Map.class);
			String email = (String) kakaoAccount.get("email");
			
			//3. 닉네임
			Map<String, Object> profile = new HashMap<String, Object>();
			profile = mapper.convertValue(kakaoAccount.get("profile"),  Map.class);
			String nickName = (String) profile.get("nickname");
			
			
			System.out.println(kakaoId);
			System.out.println(email);
			System.out.println(nickName);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		

		
	}
	

}
