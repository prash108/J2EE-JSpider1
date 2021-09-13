package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.Emp;
import com.util.DatabaseUtil;



public class Dao {
	Connection con=null;
	PreparedStatement  ps=null;
	public boolean addEmployee(Emp e) throws SQLException{
	boolean flag=false;
	int f=-1;
	con=DatabaseUtil.getConnection();
	ps=con.prepareStatement("Insert into Emp_77 values(?,?,?,?,?)");
	ps.setInt(1,e.getId());
	ps.setString(2,e.getName());
	ps.setInt(3,e.getSsnNo());
	ps.setString(4,e.getAddress());
	ps.setDouble(5,e.getSalary());
	f=ps.executeUpdate();
	if(f>0){
		flag=true;
		
	}else{
		flag=false;
	}
		
		return flag;
	}

}
