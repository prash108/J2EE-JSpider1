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

public class SearchServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//if(req.getParameter("regno").equals(null))
		
		int regno=Integer.parseInt(req.getParameter("regno"));
		
		PrintWriter out=resp.getWriter();
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		
		try
		{
			//jdbc steps
			/*driver class :com.mysql.jdbc.Driver
			 * 1.load the driver
			 */
			//
			
			DriverManager.registerDriver(new Driver());
			
			String dbUrl="jdbc:mysql://localhost:3306/bece_14?user=root&password=root";
			
			con=DriverManager.getConnection(dbUrl);
			
			/*
			 * issue the query
			 */
			String query=" select * from students_info si,students_otherinfo so,guardian_info gi " 
						 +" where si.regno=so.regno and so.regno=gi.regno and gi.regno=si.regno"
						 + " and "
						 + " si.regno=? ";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, regno);
			rs=pstmt.executeQuery();
			/*
			 * 4.process the query
			 */
			String output="";
			if(rs.next())
			{
				regno=rs.getInt("regno");
				String fName=rs.getString("firstname");
				String mName=rs.getString("middlename");
				String lName=rs.getString("lastname");
				String gfName=rs.getString("gfirstname");
				String gmName=rs.getString("gmiddlename");
				String isAdmin=rs.getString("isAdmin");
				
				output="<html>"
						+ "<body>"
						+ "<table border=\"1\" width=\"100%\">"
						+ "<tr><td>First Name</td><td>Middle Name</td><td>Last Name</td>"
						+ "<tr><td>"+fName+"</td><td>"+mName+"</td><td>"+lName+"</td>"
						+ "</table>"
						+ "</body>"
						+ "</html>";
				out.println(output);
				
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
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
