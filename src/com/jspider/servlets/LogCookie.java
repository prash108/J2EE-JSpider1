package com.jspider.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogCookie extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String regno=req.getParameter("regno");
	String pass=req.getParameter("password");
	String remember=req.getParameter("rememberme");
	
	if(remember!=null) {
	Cookie cookie1=new Cookie("Regno",regno);
	Cookie cookie2=new Cookie("Password",pass);
	
	resp.addCookie(cookie1);
	resp.addCookie(cookie2);
	}
	resp.setContentType("text/Plain");
	PrintWriter out=resp.getWriter();
	out.print("Loged In Successfully");
}
}
