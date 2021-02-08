package com.kh.toy.sms.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.toy.common.util.http.HttpUtil;
import com.kh.toy.test.controller.SMS;


@WebServlet("/sms/*")
public class smsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public smsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		switch (uriArr[uriArr.length-1]) {
		case "form": goForm(request, response); break;
		case "send": sendSMS(request, response); break;
		default:
			response.setStatus(404);
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void goForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/SMS/SMS.jsp").forward(request, response);
	}
	
	protected void sendSMS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String to = request.getParameter("to");
		String content = request.getParameter("content");
		
		HttpUtil httpUtil = new HttpUtil();
		SMS sms = new SMS();
		
		String url = "https://sens.apigw.ntruss.com/sms/v2/services/ncp:sms:kr:263561292248:lets_share/messages";
		String body = sms.getSMSBody(to, content);
		Map<String, String> headers;
		
		try {
			headers = sms.getSMSHeaders();
			String res = httpUtil.post(url, headers, body);
			System.out.println(res);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
