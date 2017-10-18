package com.jspider.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException 
{
	
	Cookie[] cook=req.getCookies();
	
	
	
	
	resp.setContentType("text/html");
	
	PrintWriter out=resp.getWriter();
	
	if(cook!=null) {
	out.print("<html>"
			+"<head>"
			+"<title>Insert title here</title>"
			+"</head>"
			+"<body>"
			+"<form action=\"./log\" method=\"post\">"
			+"<table>\r\n" + 
			"			<tr>\r\n" + 
			"				<td>Regno</td>\r\n" + 
			"				<td><input type=\"text\" name=\"regno\" value="+cook[0].getValue()+"></td>\r\n" + 
			"			</tr>"
			+"<tr>\r\n" + 
			"				<td>password</td>\r\n" + 
			"				<td><input type=\"password\" name=\"password\" value="+cook[1].getValue()+"></td>\r\n" + 
			"			</tr>\r\n" + 
			"			<tr>\r\n" + 
			"				<td>Remember Me</td>\r\n" + 
			"				<td><input type=\"checkbox\" name=\"rememberme\" checked value=\"YES\"></td>\r\n" + 
			"			</tr>\r\n" + 
			"			<tr>\r\n" + 
			"				<td><input type=\"submit\" name=\"Login\"></td>\r\n" + 
			"			</tr>\r\n" + 
			"</table>\r\n" + 
			"\r\n" + 
			"	</form>\r\n" + 
			"</body>\r\n" + 
			"</html>");
			
	}
	else {
		out.print("<html>"
				+"<head>"
				+"<title>Insert title here</title>"
				+"</head>"
				+"<body>"
				+"<form action=\"./log\" method=\"post\">"
				+"<table>\r\n" + 
				"			<tr>\r\n" + 
				"				<td>Regno</td>\r\n" + 
				"				<td><input type=\"text\" name=\"regno\"></td>\r\n" + 
				"			</tr>"
				+"<tr>\r\n" + 
				"				<td>password</td>\r\n" + 
				"				<td><input type=\"password\" name=\"password\"></td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr>\r\n" + 
				"				<td>Remember Me</td>\r\n" + 
				"				<td><input type=\"checkbox\" name=\"rememberme\" value=\"YES\"></td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr>\r\n" + 
				"				<td><input type=\"submit\" name=\"Login\"></td>\r\n" + 
				"			</tr>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"	</form>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		System.out.println("login successfull");
		
	}
}
}
