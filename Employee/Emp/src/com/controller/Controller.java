package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Emp;
import com.service.Service;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		RequestDispatcher rd=null;
		Service service=new Service();
		Emp e1=new Emp();
		if("add".equalsIgnoreCase(action)){
			e1.setId(Integer.parseInt(request.getParameter("id")));
			e1.setName(request.getParameter("name"));
			e1.setSsnNo(Integer.parseInt(request.getParameter("ssnNo")));
			e1.setAddress(request.getParameter("address"));
			e1.setSalary(Double.parseDouble(request.getParameter("salary")));
			boolean flag=false;
			try {
				flag = service.addEmployee(e1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag==true){
				System.out.println("added");
			}
			request.setAttribute("ee", e1);
			rd=request.getRequestDispatcher("addResult.jsp");
			rd.forward(request, response);
		}
	}

}
