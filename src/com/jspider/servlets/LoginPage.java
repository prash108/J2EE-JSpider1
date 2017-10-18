package com.jspider.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class LoginPage extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		int regno = Integer.parseInt(req.getParameter("regno"));
		String password = req.getParameter("passwd");
		PrintWriter out = resp.getWriter();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
//			1.Load the Driver
			Driver ref = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
			
//			2.getting the connection via driver
			String dburl = "jdbc:mysql://localhost:3306/bece_14?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			
//			3.issue the sql query with db connection 
			String query = "Select * from students_info si,students_otherinfo so "
					+ " where "
					+ " si.regno = so.regno "
					+ " and "
					+ " so.regno = ? "
					+ " and "
					+ " so.password=? ";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, regno);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
//			4.Process sql query
			String output="";
			if(rs.next()) {
				out.println("login Successfull");
				regno=rs.getInt("regno");
				String isAdmin = rs.getString("isAdmin");
				
				String fnm=rs.getString("firstname");
				String mnm=rs.getString("middlename");
				String lnm=rs.getString("lastname");
				
				String pswd=rs.getString("password");
				
				output = "<html>"
						+ "<body>"
						+ "<fieldset>"
						+ "<legend>Student Login</legend>"
						+ "<table style=\"width:50%;\" border=\"5\" style=\"border-color: blue;\">"
						+ "<tr>"
						+ "<td> regno </td>"
						+ "<td>firstname</td>"
						+ "<td>middlename</td>"
						+ "<td>lastname</td>"
						+ "<td>password</td>"
						+ "</tr><tr>"
						+ "<td>"+regno+"</td>"
						+ "<td>"+fnm+"</td>"
						+ "<td>"+mnm+"</td>"
						+ "<td>"+lnm+"</td>"
						+"<td>"+pswd+"</td>"
						+ "</tr>"
						+ "</table>"
						+ "</fieldset>"
						+ "</body>"
						+ "</html>";
			
				resp.setContentType("text/html");
				out.println(output);		
						
				if (isAdmin.equals("Y")) {
					out.println("<a href = \"http://localhost:8080/studentsApp/ViewAllStudent\"> click here </a> To view all Student info");
				} 
				
			} 
				
			
				
				
		}catch (Exception e) {
			out.println("login Unsuccessfull");
			out.println("<html>"
					+ "<body>"
					+ "<h1>login Unsuccessfull</h1>"
					+ "</body>"
					+ "</html>");
			
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(rs!=null)
					rs.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(pstmt!=null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	

}
