package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import java.sql.SQLException;


import com.bean.Employee;
import com.util.DatabaseUtil;

public class DAO {

	PreparedStatement ps=null;
	ResultSet rs=null;
	public boolean registerEmployee(Employee e) throws SQLException,ClassNotFoundException{
	boolean flag=false;
	int f=-1;
	Connection con=DatabaseUtil.getConnection();
	try{
		
		
		ps=con.prepareStatement("insert into Employee_12 values(?,?,?,?,?)");
		ps.setInt(1,e.getEid());
		ps.setString(2,e.getName());
		ps.setString(3,e.getGender());
		ps.setString(4,e.getAddress());
		ps.setInt(5,e.getSsnNo());
		f=ps.executeUpdate();
		System.out.println("daooo part");

	if(f>0){
		flag=true;
	}
	else{
		flag=false;
	}
	
	}
	catch(SQLException e1){
		e1.printStackTrace();
	}
	return flag;
	}
	}


