package com.kh.toy.test.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.ToAlertException;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SMS {

	public SMS() {
		
	}
	
	public static void main(String[] args) {
		
	}
	
	
	private String makeSignature() throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
		long lTime = System.currentTimeMillis ( );
		String time = Long.toString(lTime);
		String space = " ";					// one space
		String newLine = "\n";					// new line
		String method = "POST";					// method
		String url = "/sms/v2/services/ncp:sms:kr:263561292248:lets_share/messages";	// url (include query string)
		String timestamp = time;			// current timestamp (epoch)
		String accessKey = "W2t9YLUPPjTsM9pquRd6";			// access key id (from portal or Sub Account)
		String secretKey = "k25Le7M7PFUlV3SBSZHyQ3ZxvspCSqlDnHAdLhJC";

		String message = new StringBuilder()
			.append(method)
			.append(space)
			.append(url)
			.append(newLine)
			.append(timestamp)
			.append(newLine)
			.append(accessKey)
			.toString();

		SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(signingKey);

		byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
		String encodeBase64String = Base64.encodeBase64String(rawHmac);
		
	  return encodeBase64String;
	}
	

	public Map<String, String> getSMSHeaders() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException{
		
		String time = Long.toString(System.currentTimeMillis ( ));
		String accessKey = "W2t9YLUPPjTsM9pquRd6";
		String secretKey = makeSignature();
		
		Map<String, String> headers= new HashMap<String, String>();
		headers.put("Content-Type", "application/json; charset=utf-8");
		headers.put("x-ncp-apigw-timestamp", time);
		headers.put("x-ncp-iam-access-key", accessKey);
		headers.put("x-ncp-apigw-signature-v2", secretKey);
		
		return headers;
	}
	
	public String getSMSBody(String to, String content) {
		JSONObject jsonObject = new JSONObject();
		JSONArray messageArray = new JSONArray();
		JSONObject messageInfo = new JSONObject();
		
		jsonObject.put("type", "SMS");
		jsonObject.put("contentType", "COMM");
		jsonObject.put("countryCode", "82");
		jsonObject.put("from", "01074861207");
		jsonObject.put("content", "안녕하세요");
		
		messageInfo.put("to", to);
		messageInfo.put("content", content);
		messageArray.add(messageInfo);
		
		jsonObject.put("messages", messageArray);
		
		String body = jsonObject.toJSONString();
		
		return body;
		
	}

}
