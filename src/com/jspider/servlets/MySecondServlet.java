package com.jspider.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class MySecondServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
	IOException 
	{
		int regno=Integer.parseInt(req.getParameter("regno")) ;
		PrintWriter out=resp.getWriter();
		Connection con=null;
		ResultSet rs=null;
		 
		try 
		{
		/*
		 * 1.load the driver
		 */
		DriverManager.registerDriver(new Driver());
		
		String dbUrl="jdbc:mysql://localhost:3306/bece_14?user=root&password=root";
		
		/*
		 * 2. get the connection via driver
		 */
		con =DriverManager.getConnection(dbUrl);
		
		/*
		 * 3. issue the sql query via connection
		 */
		
		String query="select * from students_info si,students_otherinfo so,guardian_info gi"
				     +"where si.regno=so.regno and so.regno=gi.regno and gi.regno=?";
		
		
		
		
		}
		catch(Exception e)
		{
			
		}
		   
		   
	}

}
