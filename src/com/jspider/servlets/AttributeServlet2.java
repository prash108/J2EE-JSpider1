package com.jspider.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AttributeServlet2 extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		PrintWriter out=resp.getWriter();
		//Context attribute 
	ServletContext ref2 =	getServletContext();
	String	ref3=(String)ref2.getAttribute("Data");
	System.out.println(ref3);
	out.print(ref3);
	//request Attribute
	String ref = (String) req.getAttribute("req");
	System.out.println(ref);
	out.print(ref);
	
	/*RequestDispatcher dispatcher=req.getRequestDispatcher("./AttributeServlet");
	dispatcher.
	*/}

}
