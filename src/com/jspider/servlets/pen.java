package com.jspider.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

public class pen extends HttpServlet{

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search=req.getParameter("key");
		System.out.println("search="+search);
		resp.setContentType("text/html");
		resp.sendRedirect("https://www.grainger.com/search?searchBar=true&searchQuery="+search);
		resp.sendRedirect("https://www.flipkart.com/search?q="+search);
		resp.sendRedirect("https://www.google.co.in/search?dcr="+search);
		resp.sendRedirect("https://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords="+search);
	}
          
}

