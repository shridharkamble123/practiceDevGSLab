package org.jspider.simpleinterestapp.calculate_ri;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateRI extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int acount_no=Integer.parseInt(req.getParameter("acoount_no"));
		int amount=Integer.parseInt(req.getParameter("amt"));
		String city= req.getParameter("city");
		String city_lower=city.toLowerCase();
		
		System.out.println(city_lower);
		double rate_of_interest=0;
		
		PrintWriter out=resp.getWriter();
		
		if(city_lower.equals("pune"))
		{
			rate_of_interest=(amount*5*1)/100;
			out.print("<h1>Metro-City</h1><h2>Rate Of Interest Is "+rate_of_interest+"</h2>");
		}
		
		else if(city_lower.equals("latur"))
		{
			rate_of_interest=(amount*8*1)/100;
			out.print("<h1>Urban-City</h1><h2>Rate Of Interest Is "+rate_of_interest+"</h2>");
		}
		
		else if(city_lower.equals("mumbai"))
		{
			rate_of_interest=(amount*5*1)/100;
			out.print("<h1>Metro-City</h1><h2>Rate Of Interest Is "+rate_of_interest+"</h2>");
		}
	}

	
}
