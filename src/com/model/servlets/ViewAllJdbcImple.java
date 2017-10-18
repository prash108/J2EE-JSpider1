package com.model.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

public class ViewAllJdbcImple 
{

	public List<StudentsInfoBean> viewAll()
	{
 	List<StudentsInfoBean> students=new ArrayList<StudentsInfoBean>();
	
	

	

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

		String query=  " select * from students_info si , " 
				+ " students_otherinfo so , " 
				+ " guardian_info gi "  
				+ " where si.regno=so.regno AND so.regno=gi.regno " ;
		pstmt=con.prepareStatement(query);
//		pstmt.setInt(1, regno);
//		pstmt.setString(2, password); 
		rs=pstmt.executeQuery();
		//4.process the sql query
		StudentsInfoBean student = null;
		while(rs.next())
		{
			student=new StudentsInfoBean();
			int regno=rs.getInt("regno");
			String fName=rs.getString("firstname");
			String mName=rs.getString("middlename");
			String lName=rs.getString("lastname");
			String gfName=rs.getString("gfirstname");
			String gmName=rs.getString("gmiddlename");
			String glName=rs.getString("glastname");
			String isAdmin=rs.getString("isAdmin");


			student.setRegno(regno);
			student.setFirstname(fName);
			student.setMiddlename(mName);
			student.setLastname(lName);
			student.setGfirstname(gfName);
			student.setGmiddlename(gmName);
			student.setGlastname(glName);
			student.setIsadmin(isAdmin);
			
			students.add(student);
		}

return students;
		//5.close all jdbc objects

	} catch (Exception e) 
	{
		e.printStackTrace();
		return null;
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
