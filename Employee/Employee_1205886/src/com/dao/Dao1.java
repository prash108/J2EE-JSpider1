package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Account;
import com.util.DatabaseUtil;

public class Dao1 {
	Connection con=null;
    PreparedStatement ps=null;	
    ResultSet rs=null;
	public void addAccount(Account a) throws SQLException{
		 con=DatabaseUtil.getConnection();
		   ps=con.prepareStatement("insert into account_1291704 values(?,?,?,?)");
		   ps.setInt(1,a.getNo());
		   ps.setString(2,a.getType());
		   ps.setDouble(3,a.getBalance());
		   ps.setInt(4,a.getSsnno());
		   ps.executeUpdate();
		
		
	}
}
