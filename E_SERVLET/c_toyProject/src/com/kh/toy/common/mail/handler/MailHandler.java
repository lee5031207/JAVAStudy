package com.kh.toy.common.mail.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mail/*")
public class MailHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MailHandler() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String template = request.getParameter("mailTemplate");
		
		request.getRequestDispatcher("/WEB-INF/view/mail-template/"+template+".jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
