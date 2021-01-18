package com.kh.jsp.el.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.jsp.el.model.vo.Student;


@WebServlet("/el/*")
public class ELController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public ELController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		switch(uriArr[uriArr.length-1]) {
		case "el" :
			el(request, response);
			break;
		case "elimpl":
			elimpl(request, response);
			break;
		default : 
			response.setStatus(404);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void el(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/el_jstl/el_inp.jsp")
		.forward(request, response);
	}
	protected void elimpl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터로 넘어온 국영수코 점수 합계, 평균 구하기
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		int coding = Integer.parseInt(request.getParameter("coding"));
		
		int sum = kor+eng+math+coding;
		int avg = sum/4;
		
		request.setAttribute("sum", sum);
		request.setAttribute("avg", avg);
		
		// =============================vo에 데이터를 담아서 전송=============================
		Student student = new Student(); 
		student.setName(name);
		student.setKor(kor);
		student.setEng(eng);
		student.setMath(math);
		student.setCoding(coding);
		
		request.setAttribute("student", student);
		
		// =============================Map에 데이터를 담아서 전송=============================
		Map commandMap = new HashMap<String, Object>();
		commandMap.put("name", "map에 담긴 이름 : "+name);
		commandMap.put("kor", "map에 담긴 국어 : "+kor);
		commandMap.put("eng", "map에 담긴 영어 : "+eng);
		commandMap.put("math", "map에 담긴 수학 : "+math);
		commandMap.put("coding", "map에 담긴 코딩 : "+coding);
		commandMap.put("sum", "map에 담긴 합계 : "+sum);
		commandMap.put("avg", "map에 담긴 평균 : "+avg);
		
		request.setAttribute("studentMap", commandMap);
		
		// =============================array/list에 데이터를 담아서 전송=============================
		List studentList = new ArrayList<>();
		studentList.add(student);
		studentList.add(commandMap);
		
		request.setAttribute("studentList", studentList);
		
		// =============================파라미터로 넘어온 학생 이름을 session에 저장=============================
		HttpSession session = request.getSession();
		session.setAttribute("name", name+"(LOG OUT)");
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/el_jstl/el.jsp")
		.forward(request, response);
	}

}
