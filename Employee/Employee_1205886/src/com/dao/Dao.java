package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Employee;
import com.util.DatabaseUtil;

public class Dao {
	Connection con=null;
    PreparedStatement ps=null;	
    ResultSet rs=null;
	public void addEmployee(Employee e) throws SQLException{
   con=DatabaseUtil.getConnection();
   ps=con.prepareStatement("insert into employee_1291704 values(?,?,?,?,?,?)");
   ps.setInt(1,e.getId());
   ps.setString(2,e.getName());
   ps.setString(3,e.getDesignation());
   ps.setInt(4,e.getSsnno());
   ps.setInt(5, e.getAge());
   ps.setDouble(6,e.getSalary());
   ps.executeUpdate();

}
	public ArrayList<Employee> viewEmployee() throws SQLException{
		ArrayList<Employee> eList=new ArrayList<Employee>();
		con=DatabaseUtil.getConnection();
		   ps=con.prepareStatement("select * from employee_1291704");
		   rs=ps.executeQuery();
		   while(rs.next()){
			   Employee e1=new Employee();
			   e1.setId(rs.getInt(1));
			   e1.setName(rs.getString(2));
			   e1.setDesignation(rs.getString(3));
			   e1.setSsnno(rs.getInt(4));
			   e1.setAge(rs.getInt(5));
			   e1.setSalary(rs.getDouble(6));
			   eList.add(e1);
		   }
		return eList;
	}
	
	public void updateEmployee(Employee e)throws SQLException{
		con=DatabaseUtil.getConnection();
		   ps=con.prepareStatement("update employee_1291704 set name=?,designation=?,age=?,salary=? where ssnNo=?");
		   ps.setString(1,e.getName());
		   ps.setString(2,e.getDesignation());
		   ps.setInt(3, e.getAge());
		   ps.setDouble(4,e.getSalary());
		   ps.setInt(5,e.getSsnno());
		   ps.executeUpdate();

	}
	public void deleteEmployee(Employee e)throws SQLException{
		con=DatabaseUtil.getConnection();
		   ps=con.prepareStatement("delete from employee_1291704 where ssnNo=?");
		   ps.setInt(1, e.getSsnno());
		   ps.executeUpdate();
}
}