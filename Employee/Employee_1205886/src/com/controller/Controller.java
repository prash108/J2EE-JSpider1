package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Account;
import com.bean.Employee;
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
		Employee e=new Employee();
		if("add".equalsIgnoreCase(action)){
			e.setId(Integer.parseInt(request.getParameter("id")));
			e.setName(request.getParameter("name"));
			e.setDesignation(request.getParameter("designation"));
			e.setSsnno(Integer.parseInt(request.getParameter("ssnNo")));
			e.setAge(Integer.parseInt(request.getParameter("age")));
			e.setSalary(Double.parseDouble(request.getParameter("salary")));
			
			try {
				service.addEmployee(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.setAttribute("ee",e);
			rd=request.getRequestDispatcher("addResult.jsp");
			rd.forward(request, response);
			
		}
		if("addr".equalsIgnoreCase(action)){
			Account a=new Account();
			a.setNo(Integer.parseInt(request.getParameter("no")));
			a.setType(request.getParameter("type"));
			a.setBalance(Double.parseDouble(request.getParameter("balance")));
			a.setSsnno(Integer.parseInt(request.getParameter("ssnNo")));
			
			try {
				service.addAccount(a);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.setAttribute("aa",a);
			rd=request.getRequestDispatcher("addResult1.jsp");
			rd.forward(request, response);
			
		}
		if("view".equalsIgnoreCase(action)){
			ArrayList<Employee> eList=new ArrayList<Employee>();
			try {
				eList=service.viewEmployee();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.setAttribute("el",eList);
			rd=request.getRequestDispatcher("viewResult.jsp");
			rd.forward(request, response);
			
		}
		if("upadte".equalsIgnoreCase(action)){
			Employee es=new Employee();
			es.setId(Integer.parseInt(request.getParameter("id")));
			es.setName(request.getParameter("name"));
			es.setDesignation(request.getParameter("designation"));
			es.setSsnno(Integer.parseInt(request.getParameter("ssnNo")));
			es.setAge(Integer.parseInt(request.getParameter("age")));
			es.setSalary(Double.parseDouble(request.getParameter("salary")));
			
			try {
				service.updateEmployee(es);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.setAttribute("ee",es);
			rd=request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
			
		}
		if("delete".equalsIgnoreCase(action)){
			e.setId(Integer.parseInt(request.getParameter("id")));
			e.setName(request.getParameter("name"));
			e.setDesignation(request.getParameter("designation"));
			e.setSsnno(Integer.parseInt(request.getParameter("ssnNo")));
			e.setAge(Integer.parseInt(request.getParameter("age")));
			e.setSalary(Double.parseDouble(request.getParameter("salary")));
			
			try {
				service.deleteEmployee(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			rd=request.getRequestDispatcher("delete.jsp");
			rd.forward(request, response);
			
		}
		}
	}


