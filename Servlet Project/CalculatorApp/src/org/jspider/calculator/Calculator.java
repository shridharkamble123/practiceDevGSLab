package org.jspider.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 =	Integer.parseInt(req.getParameter("num1"));
		int num2= Integer.parseInt(req.getParameter("num2"));
	
		int ans=num1+num2;
		
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1>Ans Is"+ans+"</h1>");
		
	}
	
}
