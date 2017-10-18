package com.jspider.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookieServlet extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException
{
	PrintWriter out=resp.getWriter();
	resp.setContentType("text/html");
	
	Cookie [] receivedCookie=req.getCookies();
	
	if(receivedCookie==null)
	{
		out.print("cookies are not present..........");
		
		for(Cookie rcvdcookie:receivedCookie)
		{
			String name=rcvdcookie.getName();
			
			if(name.equals("myLocationcookieRef"));
			{
				rcvdcookie.setMaxAge(0);
				resp.addCookie(rcvdcookie);
				out.print("deleted mylocation cookie...");
				break;
			}
		}
	}
			
	
	
}
}
