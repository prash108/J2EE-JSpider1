package com.jspider.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;
//import com.mysql.jdbc.Statement;

public class DisplayAll extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		PrintWriter out=resp.getWriter();

		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;

		try {
			//1.load the driver
			DriverManager.registerDriver(new Driver());

			String dbUrl="jdbc:mysql://localhost:3306/bece_14?user=root&password=root";
			//2.get the db connection via driver
			con=DriverManager.getConnection(dbUrl);

			/*
			 * 3. issue the sql query
			 */
			String query=" select * from students_info si,students_otherinfo so "
					+ " where "
					+ " si.regno=so.regno ";

			stmt=  con.createStatement();

			rs = stmt.executeQuery(query);

			String output = "<html>"
					+ "<body>"
					+ "<table border =\"1\"width=\"100%\">"
					+ "<tr><td>regno</td>"
					+ "<td>first name</td>"
					+ "<td>middle name</td>"
					+ "<td>last name</td></tr>";

			int regno;
			String firstname,middlename,lastname;
			while(rs.next()) {
				regno=rs.getInt("regno");
				firstname=rs.getString("firstname");
				middlename=rs.getString("middlename");
				lastname=rs.getString("lastname");
				output = output+"<tr>"
						+"<td>"+regno+"</td>"
						+"<td>"+firstname+"</td>"
						+"<td>"+middlename+"</td>"
						+"<td>"+lastname+"</td>"
						+ "</tr>";

			}
			output = output+"</table>"
					+ "</body>"
					+ "</html>";

       out.println(output);
       

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		




	}

}
