package com.jspider.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class ViewAllStudent extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		PrintWriter out=resp.getWriter();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		

		//1. load the driver

		try {
			DriverManager.registerDriver(new Driver());
			String dbUrl="jdbc:mysql://localhost:3306/bece_14?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			String query=" select * from students_info si, students_otherinfo so , "
					+ " guardian_info gi "
					+ " where si.regno=so.regno and so.regno=gi.regno ";
					
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			//rs=pstmt.executeQuery();
			String output="";
			//process the result
			output="<html>"
					+ "<head>"
					+ "<title>Display all Students</title>"
					+ "</head>"
					+ "<body>"
					+ "<table border='1' width=00%>"
					+"<tr>"
					+ "<td>"
					+ "Regno : "
					+ "</td>"
					+ "<td>"
					+ "firstname"
					+ "</td>"
					
					+ "<td>"
					+ "MiddleName"
					+ "</td>"
					+ "<td>"
					+ "LastName"
					+ "</td>"
					+ "<td>"
					+ "GFirstName"
					+ "</td>"
					+ "<td>"
					+ "GMiddleNAme"
					+ "</td>"
					+ "<td>"
					+ "GLASTNAME"
					+ "</td>"
					+ "<td>"
					+ "password"
					+ "</td>"
					+ "<td>"
					+ "isAdmin"
					+ "</td>"
					+"<td>"
					+ "Delete"
					+ "</td>"
					+ "<td>"
					+ "Edit"
					+ "</td>"
					
					+ "</tr>";
			while(rs.next())
			{
				int regno=rs.getInt("regno");
				String fnm=rs.getString("firstname");
				String mnm=rs.getString("middlename");
				String lnm=rs.getString("lastname");
				String gfnm=rs.getString("gfirstname");
				String gmnm=rs.getString("gmiddlename");
				String glnm=rs.getString("glastname");
				String pwd=rs.getString("password");
				String isAdmin=rs.getString("isadmin");
				
				
						output=output+"<tr>"
								
								+ "<td>"+regno+"</td>"
						
						+ "<td>"+fnm+"</td>"
						+ "<td>"+mnm+"</td>"
						+"<td>"+lnm+"</td>"
						+ "<td>"+gfnm+"</td>"
						+ "<td>"+gmnm+"</td>"
						+"<td>"+glnm+"</td>"
						+ "<td>"+pwd+"</td>"
						+ "<td>"+isAdmin+"</td>"
						+"<td> <a href=\"http://localhost:8080/studentsApp/delete?regno="+regno+"\"> DeleteRecord </a></td>"
						+"<td> <a href=\"http://localhost:8080/studentsApp/EditServletPage?regno="+regno+"\"> EditTheProfile </a></td>"
						
						;
						
						
						/*+ "<td>lastname</td>"
						+ lnm
						+ "<td>gfirstname</td>"
						+ gfnm
						+ "<td>gmiddlename</td>"
						+ gmnm
						+ "<th>glastname</th>"
						+ glnm
						+ "<th>isAdmin</th>"
						+ isAdmin
						+ "<th>password</th>"
						+ pwd
						+ "<th>Delete</th>";*/
						/*if (isAdmin.equals("Y")) {
							output=output+"<tr>"
									+ "<a href=\"http://localhost:8080/studentsApp/delete?regno=\"+regno+\">delete</a>"
									+ "</tr>";
						}*/
						
						
                }
			output=output+"</tr>"
					+ "</body>"
					+ "</html>";
					out.println(output);

		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try {
				if(con!=null)
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(stmt!=null)
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(rs!=null)
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}//end of dopost
}//end of class
