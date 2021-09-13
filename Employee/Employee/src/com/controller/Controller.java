package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String action=request.getParameter("action");
		System.out.println(action);
		RequestDispatcher rd=null;
		Service service=new Service();
		Employee e1=new Employee();
		if("register".equalsIgnoreCase(action)){
			System.out.println(action);
			e1.setEid(Integer.parseInt(request.getParameter("eid")));
			e1.setName(request.getParameter("name"));
			e1.setGender(request.getParameter("gender"));
			e1.setAddress(request.getParameter("address"));
			e1.setSsnNo(Integer.parseInt(request.getParameter("ssnNo")));
			boolean flag=false;
			try {
				System.out.println(action);

				try {
					flag = service.registerEmployee(e1);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag==true){
				System.out.println("employee added");
			}
          request.setAttribute("ee", e1);
          rd=request.getRequestDispatcher("registerResult.jsp");
          rd.forward(request, response);
		}

		
	}

}
