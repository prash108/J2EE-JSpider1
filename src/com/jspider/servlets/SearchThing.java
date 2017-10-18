package com.jspider.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchThing extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		String search=req.getParameter("key");
		String value=req.getParameter("Search");
		resp.setContentType("text/html");

		//resp.sendRedirect("https://www.grainger.com/search?searchBar=true&searchQuery="+search);
		if(value.equals("Google")){
		resp.sendRedirect("https://www.google.co.in/search?q="+search);
		}
		else {
		resp.sendRedirect("https://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords="+search);
		}

	}
}

