package com.jspider.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyGenericServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException 
	{
     PrintWriter out=resp.getWriter();
     out.print("hello this is generic servlet");
		
	}

}
