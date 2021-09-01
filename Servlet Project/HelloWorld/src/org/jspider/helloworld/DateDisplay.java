package org.jspider.helloworld;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DateDisplay extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Date d1=new Date();
		System.out.println(d1); //print on console;
		
		PrintWriter out=res.getWriter();
		out.print("<h1>"+d1+"</h1>"); //print on browser;
		
		//costly resourse we have to close
		out.flush();
		out.close();
	}
	
	

}
