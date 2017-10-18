package com.jspider.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AttributeServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		resp.setContentType("text/html");
		//context Attribute
		ServletContext ref= getServletContext();
		ref.setAttribute("Data", "prashant");
		req.setAttribute("req", "val");
	System.out.println("workings");
	//request attribute
	RequestDispatcher dispatcher=req.getRequestDispatcher("./AttributeServlet2");
	dispatcher.forward(req, resp);
	}

}
