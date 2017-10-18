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

public class EditServletPage extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException 
    {
    
		
		int regnoVal=Integer.parseInt(req.getParameter("regno"));
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
//			1.load the driver
			DriverManager.registerDriver(new Driver());;
			
//			2.get the db connection
			String dbUrl="jdbc:mysql://localhost:3306/bece_14?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);
			
//			3.issue sql queries
			String query="select * from students_info si,students_otherinfo so,guardian_info gi where si.regno=so.regno and so.regno=gi.regno and si.regno=?";
			
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, regnoVal);
			rs=pstmt.executeQuery();
			
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			
			
			
//			4.process the results
			if (rs.next()) {
				
				int regno=rs.getInt("regno");
				String fnm=rs.getString("firstname");
				String mnm=rs.getString("middlename");
				String lnm=rs.getString("lastname");
				
				String isAdmin = rs.getString("isAdmin");
				String pswd=rs.getString("password");
				
				String gfnm=rs.getString("gfirstname");
				String gmnm=rs.getString("gmiddlename");
				String glnm=rs.getString("Glastname");
				out.print("<html> " +
						"<body> "+ 
						"<fieldset> "+
						"<legend>All the info about " +fnm.toLowerCase()+"</legend><br>" + 
						"<form action =\"http://localhost:8080/studentsApp/EditServlet\" method=post > "+
						"<table   width=\"100%\" > " + 
						"<tr> <td>Reg No</td> <td><input type=text name=regno value="+regno+" readonly></td></tr>" +
						"<tr><td>First Name</td> <td><input type=text name=fnm value= " +fnm+"></td> </tr>"+ 
						"<tr><td>Middle Name</td> <td><input type=text name=mnm value= " +mnm+"></td> </tr>"+  
						"<tr><td>Last Name</td> <td><input type=text name=lnm value= " +lnm+"></td> </tr>"+
						"<tr><td>Guardian First Name</td> <td><input type=text name=gfnm value= " +gfnm+"></td> </tr>"+ 
						"<tr><td>Guardian Middle Name</td> <td><input type=text name=gmnm value= " +gmnm+"></td> </tr>"+
						"<tr><td>Guardian Last Name</td> <td><input type=text name=glnm value= " +glnm+"></td> </tr>"+
						"<tr><td>isAdmin</td> <td><select name=isAdmin >"
								+ "<option value=\"Y\">Y</option>"
								+ "<option value=\"N\">N</option>"
								+ "</select></td> </tr>" +
					
						"</table> "+
						"<input type=\"submit\" value=\"update\"> "+
						"</form> "+
						"</fieldset>" + 
						"</body> " + 
						"</html>");	
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {

//			5.close all jdbc objects
			
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
