package com.jspider.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mysql.jdbc.Driver;

public class LoginServer extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		int regno=Integer.parseInt(req.getParameter("regno"));
		String password=req.getParameter("passwd");
		String output;

		PrintWriter out=resp.getWriter();

		/*
		 * 1.load the driver
		 */
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			DriverManager.registerDriver(new Driver());

			/*
			 * 2.get the db connection via driver
			 */
			String dbUrl="jdbc:mysql://localhost:3306/bece_14?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);

			String query             =  " select * from students_info si , " 
					+ " students_otherinfo so , " 
					+ " guardian_info gi "  
					+ " where si.regno=so.regno AND so.regno=gi.regno " 
					+ " AND so.regno=? AND so.password=? ";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, regno);
			pstmt.setString(2, password); 
			rs=pstmt.executeQuery();
			//4.process the sql query
			if(rs.next())
			{
				regno=rs.getInt("regno");
				String fName=rs.getString("firstname");
				String mName=rs.getString("middlename");
				String lName=rs.getString("lastname");
				String gfName=rs.getString("gfirstname");
				String gmName=rs.getString("gmiddlename");
				String glName=rs.getString("glastname");
				String isAdmin=rs.getString("isAdmin");



				output = "<html>"
						+ "<body>"
						+ "<table border=\"1\" width=\"100%\">"
						+ "<tr><td>First Name</td><td>Middle Name</td><td>Last Name</td>"
						+"<td>gFirst Name</td><td>gMiddle Name</td><td>gLast Name</td></tr>"
						+ "<tr><td>"+fName+"</td><td>"+mName+"</td><td>"+lName+"</td>"
						+ "<td>"+gfName+"</td><td>"+gmName+"</td><td>"+glName+"</td></tr>"
						+ "</table>"
						+ "</body>"
						+ "</html>";

				out.println(output);
				if(isAdmin.equals("Y"))
				{
					out.println("<a href=\"http://localhost:8080/studentsApp/CreateProfileServlet\">click here to view all students</a>");
				}
				else
				{
					out.println("sorry ,you are not administry part ");
				}

			}
			else
			{
				output="<html>"
						+ "<body>"
						+ "<h1>Data is not available</h1>"
						+ "</body>"
						+ "</html>";
				out.println(output);
			}


			//5.close all jdbc objects

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null)
					con.close();
			}
			catch(Exception e) {
				System.out.println(e.getStackTrace());
			}
			try {
				if(pstmt!=null)
					pstmt.close();
			}
			catch(Exception e) {
				System.out.println(e.getStackTrace());
			}
			try {
				if(rs!=null)
					rs.close();
			}
			catch(Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
	}
}
