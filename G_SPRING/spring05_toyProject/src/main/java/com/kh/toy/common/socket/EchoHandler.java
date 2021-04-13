package com.kh.toy.common.socket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.kh.toy.member.model.vo.Member;

public class EchoHandler extends TextWebSocketHandler{
	
	//접속한 세션들을 List에 넣어줄 리스트
	List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();
	
	//세션 아이디와 회원 아이디를 저장할 리스트
	Map<String, WebSocketSession> userSessionMap = new HashMap<String, WebSocketSession>();
	
	@Override //연결 시작될때 동작할 메서드 
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		sessions.add(session);
		userSessionMap.put(getUserId(session), session);
		//System.out.println("연결 성공 : " + userSessionMap.toString());
		
	}
	
	@Override //연결 해제될때 동작할 메서드
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		sessions.remove(session);
		userSessionMap.remove(session.getId());
		//System.out.println("연결 해제 : " + userSessionMap.toString());
		
	}
	
	@Override //클라이언트에서 send를 이용해서 메시지 발송을 한 경우 이벤트 핸들링
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	
		System.out.println(message);
		//super.handleTextMessage(session, message);
	}
	
	
	
	private String getUserId(WebSocketSession session) {
		
		//session에서 로그인한 회원은 아이디를 리턴하고 로그인안한 세션은 세션 아이디 반환
		Map<String, Object> httpSession = session.getAttributes();
		return httpSession.get("userInfo") == null ? session.getId() : ((Member) httpSession.get("userInfo")).getUserId();
		
	}
	
}
