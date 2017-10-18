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

public class CreateProfileServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		PrintWriter out=resp.getWriter();
      //1.get all the data from the form and store it
		
		String regno=req.getParameter("regno");
		String firstname=req.getParameter("firstname");
		String middlename=req.getParameter("middlename");
		String lastname=req.getParameter("lastname");
		
		
		String gfirstname=req.getParameter("gfirstname");
		String gmiddlename=req.getParameter("gmiddlename");
		String glastname=req.getParameter("glastname");
		
		String isadmin=req.getParameter("select");
		String password=req.getParameter("password");
		
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		
		//1.load the driver
		 try {
			DriverManager.registerDriver(new Driver());
			
			//2.get the db connection via driver
			String dbUrl="jdbc:mysql://localhost:3306/bece_14?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			//3.issue the sql query 
			String query1=" insert into students_info " 
						+ " ( regno,firstname,middlename,lastname ) " 
						+ " values(?,?,?,?) ";
			pstmt1=con.prepareStatement(query1);
			
			pstmt1.setInt(1,Integer.parseInt(regno));
			pstmt1.setString(2, firstname);
			pstmt1.setString(3, middlename);
			pstmt1.setString(4, lastname);
			
			int count1=pstmt1.executeUpdate();
			
			String query2=" insert into students_otherinfo "
					+ " (regno,isadmin,password) "
					+ " values(?,?,?) ";
			pstmt2=con.prepareStatement(query2);
			pstmt2.setInt(1, Integer.parseInt(regno));
			pstmt2.setString(2, isadmin);
			pstmt2.setString(3, password);
			
			int count2=pstmt2.executeUpdate();
			
			String query3=" insert into guardian_info "
					+ " (regno,gfirstname,gmiddlename,glastname) "
					+ " values(?,?,?,?)";
			pstmt3=con.prepareStatement(query3);
			pstmt3.setInt(1, Integer.parseInt(regno));
			pstmt3.setString(2, gfirstname);
			pstmt3.setString(3, gmiddlename);
			pstmt3.setString(4, glastname);
			
			int count3=pstmt3.executeUpdate();
			
			//4process the result
			if(count1==1 && count2==1 && count3==1)
			{
				out.print("successfull created profile");
				
			}
			else
			{
			out.print("failed to creat the profile");
			}
		} catch (Exception e) {
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
			 try {if(pstmt1!=null)
				pstmt1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {if(pstmt2!=null)
				pstmt2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {if(pstmt3!=null)
				pstmt3.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		}//end of main
}//end of class
