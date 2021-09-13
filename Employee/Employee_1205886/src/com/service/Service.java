package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Account;
import com.bean.Employee;
import com.dao.Dao;
import com.dao.Dao1;

public class Service {
	
	public void addEmployee(Employee e) throws SQLException{
		Dao dao=new Dao();
		dao.addEmployee(e);
	}
	public void addAccount(Account a) throws SQLException{
		Dao1 dao1=new Dao1();
		dao1.addAccount(a);
	}
	public ArrayList<Employee> viewEmployee() throws SQLException{
		Dao dao=new Dao();
		return dao.viewEmployee();
	}
	public void updateEmployee(Employee e)throws SQLException{
		Dao dao=new Dao();
		dao.updateEmployee(e);	
	}
	public void deleteEmployee(Employee e)throws SQLException{
		Dao dao=new Dao();
		dao.deleteEmployee(e);	
	}
}
