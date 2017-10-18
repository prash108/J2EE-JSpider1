package com.jspider.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCookieServlet extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException 
{
	
	PrintWriter out=resp.getWriter();
	resp.setContentType("text/html");
	Cookie myNamecookieRef =new Cookie("myName" ,"prashant");
	
	Cookie myLocationcookieRef =new Cookie("mylocation" ,"patna");
	myLocationcookieRef.setMaxAge(7*24*60*60);
	resp.addCookie(myNamecookieRef);
	resp.addCookie(myLocationcookieRef);
	out.print("cookies are created....");
	
}
}
