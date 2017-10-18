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

public class DeleteServlet extends HttpServlet
{
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException 
  {
   int regno=Integer.parseInt(req.getParameter("regno"));
   Connection con=null;
   PreparedStatement pstmt1=null;
   PreparedStatement pstmt2=null;
   PreparedStatement pstmt3=null;
   PrintWriter out=resp.getWriter();
   
   
   try {
	DriverManager.registerDriver(new Driver());
	String dbUrl="jdbc:mysql://localhost:3306/bece_14?user=root&password=root";
	con=DriverManager.getConnection(dbUrl);
	String query1=" delete from  students_info where regno=? ";
	pstmt1=con.prepareStatement(query1);
	pstmt1.setInt(1, regno);
	int count1=pstmt1.executeUpdate();
	
	String query2=" delete from students_otherinfo where regno=? ";
	pstmt2=con.prepareStatement(query2);
	pstmt2.setInt(1, regno);
	int count2=pstmt2.executeUpdate();
	
	String query3=" delete from guardian_info where regno=? ";
	pstmt3=con.prepareStatement(query3);
	pstmt3.setInt(1, regno);
	int count3=pstmt3.executeUpdate();
out.println(count1+count2+count3);	
	if(count1==1 && count2==1 && count3==1)
	{
		out.println("deleted successfullyyyyyy");
		
	}
	else
	{
		out.println("not deleted from databases");
	}
	
	
} catch (SQLException e) {
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
		   if(pstmt1!=null)
		pstmt1.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   try {
		   if(pstmt2!=null)
		pstmt2.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   try {
		   if(pstmt3!=null)
		pstmt3.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
  
  
  }
}
