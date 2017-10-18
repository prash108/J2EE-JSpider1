package com.jspider.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet
{
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     PrintWriter out = resp.getWriter();
     Date date=new Date();
     String output="<html>"
     		+ "<body>"
     		+ "<h1> Hello World </h1><br>"
     		+ "<font color=\"blue\">"
     		+ "<h3>"+date+"</h3>"       		
     		+ "</body>"
     		+ "</html>";
     
     out.println(output);
 }
 
}
