package com.jspider.practise;

import java.io.IOException;
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

public class CreateProfile extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			                 throws ServletException, IOException 
	{
     Connection con=null;
     PreparedStatement pstmt=null;
     ResultSet rs=null;
     
     try {
    	//1.load the driver
		DriverManager.registerDriver(new Driver());
		
		String dbUrl="jdbc:mysql://localhost:3306/bece_14?user=root&password=root";
		//2.get the db connection via driver
		con=DriverManager.getConnection(dbUrl);
		
		//3.issue the sql query
		
		String query="create table customer_details(number )";
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
	
	}

}
