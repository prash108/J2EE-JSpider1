package com.service;

import java.sql.SQLException;

import com.bean.Emp;
import com.dao.Dao;

public class Service {
	Dao dao=new Dao();
	public boolean addEmployee(Emp e) throws SQLException{
	return dao.addEmployee(e);	
	}

}
