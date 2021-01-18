package com.kh.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.servlet.filter.ViewWrapper;

@WebServlet("/filter")
public class H_Filter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public H_Filter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ViewWrapper vw = (ViewWrapper) request; 
		vw.testPclassWrapper();
		
		request.getRequestDispatcher("h_filter")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
