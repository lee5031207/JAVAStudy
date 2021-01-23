package com.kh.toy.common.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.kh.toy.common.code.Code;
import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.ToAlertException;

public class MailSender {
	
	//1.Session 객체 생성
	//2.MimeMessage 작성
	//  * Message header 작성
	//  * multipart 생성
	//  * Message Body 작성
	
	
	public void sendEmail(String to, String subject, String htmlText){	
	    try {
	        MimeMessage msg = new MimeMessage(getSession());
	        msg.setFrom(new InternetAddress(Code.EMAIL.desc));
	        msg.setRecipients(Message.RecipientType.TO, to);
	        msg.setSubject(subject);
	        msg.setSentDate(new Date());
	        msg.setContent(getMultipart(htmlText)); //message Body에 추가
	        Transport.send(msg); //전송
	    } catch (MessagingException mex) {
	        throw new ToAlertException(ErrorCode.MAIL01,mex);
	    }
	}
	
	public Session getSession() { //세션 만드는 메서드
		
		//1. SMTP통신을 위한 Session객체 생성
		// 인증 정보 저장
		PasswordAuthentication pa = new PasswordAuthentication(Code.EMAIL.desc, "yoo403010#");
				
		//1-2. 통신할 SMTP 서버 설정 작성
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.naver.com"); //네이버에서 요청한 주소와 포트번호 넣어준다
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.auth", "true");
				
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			//익명 클래스
			protected PasswordAuthentication getPasswordAuthentication() {
				return pa;
				}
		});
		
		return session;
	}
	
	private Multipart getMultipart(String htmlText) throws MessagingException {
//		  String htmlText = "<h1>Hi</h1>";
//        htmlText += "<h2>ToyProject에 오신것을 환영합니다</h2>";
//        htmlText += "<h2>아래의 링크를 눌러 회원가입을 마무리 하세요</h2>";
//        htmlText += "<a href='"+Code.DOMAIN+"/member/joinimpl'>확인</a>";
        
        Multipart mp = new MimeMultipart();
        MimeBodyPart htmlPart = new MimeBodyPart();
        
        //보내고 싶은 html 코드 작성
        htmlPart.setContent(htmlText, "text/html; charset=UTF-8");
        
        //Multipart 객체에 추가
        mp.addBodyPart(htmlPart);
        
        return mp;
	}
}
