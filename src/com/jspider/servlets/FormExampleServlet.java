package com.jspider.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormExampleServlet extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
  {

    PrintWriter out=resp.getWriter();
    String nameval=req.getParameter("name");
    String passwordval=req.getParameter("password");
    String Genderval=req.getParameter("Gender");
    String educationval=req.getParameter("select");
    String[] knowval=req.getParameterValues("know");
    String[] havingval=req.getParameterValues("Have");
    String aboutMe=req.getParameter("aboutMe");
    
    String output="<html>"
    		+ "<body>"
    		+ "name is:"
    		+ nameval
    		+"password is :"
    		+ passwordval
    		+"gender is :"
    		+ Genderval
    		+"education is :"
    		+ educationval
    		+"know :"
    		+ Arrays.toString(knowval)
    		+ "having :"
    		+ Arrays.toString(havingval)
    		+ "about me :"
    		+ aboutMe
    		+ "</body>"
    		+ "</html>";
    out.println(output);
    		
  
  
  
  
  
  
  
  
  
  }
}
