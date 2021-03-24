package com.kh.toy.test0322;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	UserDao userDao = new UserDao();
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = (String) request.getAttribute("userId");
		String userPwd = (String) request.getAttribute("userPwd");
		User user = new User();
		user.setUserId(userId);
		user.setUserPwd(userPwd);
		
		if(userDao.loginCheck(user) != null) {
			request.getSession().setAttribute("User",user);
		}
		
		request.getRequestDispatcher("/WEB-INF/view/member/index.html")
		.forward(request, response);
	}

}
