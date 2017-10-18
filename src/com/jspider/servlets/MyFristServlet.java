package com.jspider.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFristServlet extends HttpServlet 
{
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	   //1.java code to generate current date and time
	   Date dateRef=new Date();
	   String currentDate=dateRef.toString();
	   PrintWriter out=resp.getWriter();
	   
	   String fname=req.getParameter("fname");
	   String lname=req.getParameter("lname");
	   
	   
	   
	   //2. generate html response
	   
	   String htmlRes= "<html>"
	   		+ "<body>"
	   		+ "<h1>"
	   		+ "current Date and time is:"
	   		+ "<font color=\"blue\">"
	   		+ "<br>"
	   		+ currentDate
	   		+ "</font>"
	   		+ "</h1>"
	   		+ "<h3>First Name: "+ fname +"</h3><br>"
	   		+ "<h3>Last Name: "+ lname +"</h3></br>"
	   		+ "</body>"
	   		+ "</html>";
	   //3.send html response to browser via web server resp. set content type
	  
	   out.print(htmlRes);
	   
}//end of doGet
   
}//end of class
