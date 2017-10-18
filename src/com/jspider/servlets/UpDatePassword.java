package com.jspider.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class UpDatePassword extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{

		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		int regno=Integer.parseInt(req.getParameter("regno"));
		String oldpassword=req.getParameter("password");
		String newpassword1=req.getParameter("password1");
		String newpassword2=req.getParameter("password2");
		Connection con=null;
		PreparedStatement pstmt=null;


		if(newpassword1.equals(newpassword2))
		{
			//1.load the driver
			try {
				Driver dref=new Driver();
				DriverManager.registerDriver(dref);
			//2.get connection
				String dbUrl="jdbc:mysql://localhost:3306/bece_14?user=root&password=root";
				con=DriverManager.getConnection(dbUrl);
				//3.passing the query
				String query=" update students_otherinfo "
						+ " set password=? "
						+ " where regno=? and password=? ";
				pstmt=con.prepareStatement(query);
				
				pstmt.setString(1, newpassword1);
				pstmt.setInt(2, regno);
				pstmt.setString(3, oldpassword);
				int count =pstmt.executeUpdate();
					//4.proceesing the db result
				if(count==1)
				{
					out.println("password is updated ");
				}
				else
				{
					out.println("password is not updated");
				}
			}

				
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			finally
			{
			try {
				if (con!=null) {
					con.close();
				}
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
		

		}else
		{
			out.print("password is not matching ... ");
		}
		
}
}













