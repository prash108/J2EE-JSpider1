package com.controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.servlets.JdbcImple;
import com.model.servlets.StudentsInfoBean;

public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int regno=Integer.parseInt(req.getParameter("regno"));
		String password=req.getParameter("passwd");
		String isChecked=req.getParameter("rememberme");
		
		if(isChecked != null)
		{
			Cookie cookie=new Cookie("regno", ""+regno);
			resp.addCookie(cookie);
			
		}
		JdbcImple db=new JdbcImple();
		StudentsInfoBean student=db.login(regno,password);
		
		req.setAttribute("student", student);
		RequestDispatcher rd=req.getRequestDispatcher("./LoginResultsServlet");
		rd.forward(req, resp);
	}

}
