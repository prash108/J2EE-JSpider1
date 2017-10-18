package com.controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.servlets.JdbcImple;
import com.model.servlets.StudentsInfoBean;
import com.model.servlets.ViewAllJdbcImple;

public class ViewAllStudentsController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//int regno=Integer.parseInt(req.getParameter("regno"));
		//String password=req.getParameter("passwd");
		//String isChecked=req.getParameter("rememberme");
		
		/*if(isChecked != null)
		{
			Cookie cookie=new Cookie("regno", ""+regno);
			resp.addCookie(cookie);
			
		}*/
		ViewAllJdbcImple db=new ViewAllJdbcImple();
		List<StudentsInfoBean> students=db.viewAll();
		
		req.setAttribute("students", students);
		RequestDispatcher rd=req.getRequestDispatcher("./ViewAllStudents");
		rd.forward(req, resp);
	}

}
