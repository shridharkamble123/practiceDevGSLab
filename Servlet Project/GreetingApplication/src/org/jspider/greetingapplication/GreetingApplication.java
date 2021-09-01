package org.jspider.greetingapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GreetingApplication extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out;
		GregorianCalendar time=new GregorianCalendar();
		int hour=time.get(Calendar.HOUR_OF_DAY);
		int min=time.get(Calendar.MINUTE);
		int day=time.get(Calendar.DAY_OF_MONTH);
		int month=time.get(Calendar.MONTH);
		int year=time.get(Calendar.YEAR);
		
		out=res.getWriter();
		out.print("<h1>The Current Time Is "+hour+":"+min+"</h1><br>");
		out.print("<h1>Todays date is "+month+"/"+day+"/"+year+"</h1><br>");
		System.out.println(month);
		if(hour<12)
		{
			System.out.println(month);
			out.print("<h1>Good Morning</h1>");
			
		}
		else if(hour<17 && !(hour==12))
		{
			out.print("<h1>Good AfterNoon</h1>");
			
		}
		
		else 
		{
			out.print("<h1>Good Evening</h1>");
		}
		out.flush();
		out.close();
	}

}
