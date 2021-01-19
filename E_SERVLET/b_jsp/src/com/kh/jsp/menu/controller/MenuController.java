package com.kh.jsp.menu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menu/*")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MenuController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		switch(uriArr[uriArr.length-1]) {
		case "menu" :
			menu(request, response);
			break;
		case "order" :
			order(request, response);
			break;
		default : 
			response.setStatus(404);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void menu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/menu/menu.jsp")
		.forward(request, response);
	}
	private void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트가 food라는 이름의 파라미터로 보내는 데이터를 받아서 String 배열에 저장
		//   request.getParameter사용 X. servletAPI 찾아보셈, 하나의 파라미터 네임으로 넘어온여러 값 처리하는거
		String[] order = request.getParameterValues("food");
		
		//2. 사용자가 주문한 메뉴를 받아서 결제 가격을 계산
		//   피자:10000원, 햄버거:5000원, 회:70000원, 치킨:18000원
		Map menuPan = new HashMap<String, Integer>();
		menuPan.put("피자", 10000);
		menuPan.put("햄버거", 5000);
		menuPan.put("치킨", 18000);
		menuPan.put("회", 70000);
		
		Map orderMap = new HashMap<String, Integer>();
		int total = 0;
		for (String food : order) {
			orderMap.put(food, menuPan.get(food));
			total += (int)menuPan.get(food);
		}

		//3. Receipt.jsp 에 결제금액정보, 주문한 음식별 가격을 담아서 요청을 재지정, Map과 List적극 활용!
		request.setAttribute("total", total);
		request.setAttribute("orderMap", orderMap);
		
		request.getRequestDispatcher("/WEB-INF/view/menu/receipt.jsp")
		.forward(request, response);

	}

}
