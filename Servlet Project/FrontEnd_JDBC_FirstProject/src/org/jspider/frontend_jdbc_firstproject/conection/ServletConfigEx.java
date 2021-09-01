package org.jspider.frontend_jdbc_firstproject.conection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletConfigEx extends HttpServlet {
	Connection con =null;
	PrintWriter out=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		String driver=config.getInitParameter("driver");
		String url=config.getInitParameter("url");
		String user=config.getInitParameter("user");
		String password=config.getInitParameter("password");
		
		try {
			System.out.println(driver);
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
//			System.out.print("Connection SuccessFull");
			
		
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dept=req.getParameter("depts");
		out=resp.getWriter();
		
		try {
			pstmt=con.prepareStatement("select * from college.dept where dept_name=?");
			pstmt.setString(1, dept);
			
			rs=pstmt.executeQuery();
			System.out.println(rs);
			
//			while(rs.next())
//			{
//				System.out.println(rs.getString(1));
//			}
			out.print("<html>");
			out.print("<style> table{\r\n" + 
					"		border: 2px solid gray;\r\n" + 
					"		border-radius:30px;\r\n" + 
					"		padding: 20px;\r\n" +	
					"	} body{\r\n" + 
					"		background-color: #FAFA33;\r\n" + 
					"		\r\n" + 
					"	}"+"</style>");
			out.print("<body>");
			out.print("<h1> Lis Of Student In <i>"+dept+ "</i> Department </h1>");
			out.print("<table border=\"1\" align=\"center\">");
			out.print("<thead >");
			out.print("<tr>");
			out.print("<th>Roll No</th>");
			out.print("<th>Student Name</th>");
			out.print("<th>Department</th>");
			out.print("</tr>");
			out.print("</thead>");
			out.print("<tbody>");
			
				while(rs.next())
				{
					out.print("<tr>");
					out.print("<td>"+rs.getString(1)+"</td>");
					out.print("<td>"+rs.getString(2)+"</td>");
					out.print("<td>"+rs.getString(3)+"</td>");
					out.print("</tr>");
				}
			
			out.print("</tbody>");
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");
			
			
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			if(rs!=null)
			{
				try {
					rs.close();
					
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}


	@Override
	public void destroy() {
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
}
