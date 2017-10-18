package com.jspider.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class EditServlet extends HttpServlet 
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int regno = Integer.parseInt(req.getParameter("regno"));
		String firstname = req.getParameter("fnm");
		String middlename = req.getParameter("mnm");
		String lastname = req.getParameter("lnm");
		String gfirstname = req.getParameter("gfnm");
		String gmiddlename = req.getParameter("gmnm");
		String glastname = req.getParameter("glnm");
		String isadmin = req.getParameter("isadmin");
		resp.setContentType("text/html");

    PrintWriter out=resp.getWriter();
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

		try {

			// 1.Load the Driver
			// Driver Class: com.mysql.jdbc.Driver
			// java.sql.Driver driveref =(java.sql.Driver)
			// Class.class.forName(driverclass).newInstance();

            DriverManager.registerDriver(new Driver());
			// 2.Get the "DB Connection" via "Driver"
			String dbUrl = "jdbc:mysql://localhost:3306/bece_14?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);

			// 3.Issue "SQL Queries" via "Connection"
			String query1 = "update students_info set firstname=? ,middlename=? ,lastname=? where regno=?";
			pstmt1 = con.prepareStatement(query1);
			pstmt1.setString(1, firstname);
			pstmt1.setString(2, middlename);
			pstmt1.setString(3, lastname);
			pstmt1.setInt(4, regno);
			int count1 = pstmt1.executeUpdate();
			

			String query2 = "update guardian_info set gfirstname=? ,gmiddlename=? ,glastname=? where regno=?";
			pstmt2 = con.prepareStatement(query2);
			pstmt2.setString(1, gfirstname);
			pstmt2.setString(2, gmiddlename);
			pstmt2.setString(3, glastname);
			pstmt2.setInt(4, regno);
			int count2 = pstmt2.executeUpdate();
			

			String query3 = "update students_otherinfo set isadmin=?  where regno=?";
			pstmt3 = con.prepareStatement(query3);
			pstmt3.setString(1,isadmin);
			pstmt3.setInt(2, regno);
			int count3 = pstmt3.executeUpdate();
			
			if(count1==1||count2==1||count3==1)
			{
				out.println("<center>------------------------<BR>");
				out.println("Record Updated!!<BR>");
				out.println("------------------------</center>");
			}
			else{
				out.println("<center>------------------------");
				out.println("Record not Updated!!");
				out.println("------------------------</center>");
			}//End of if
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 5.Close All "JDBC Objects"
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt1 != null) {
					pstmt1.close();
				}
				if (pstmt2 != null) {
					pstmt2.close();
				}
				if (pstmt3 != null) {
					pstmt3.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} // End of Outer try catch block
	}
  
  
  
  
  }

