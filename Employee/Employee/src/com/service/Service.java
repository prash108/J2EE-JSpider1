package com.service;

import java.sql.SQLException;


import com.bean.Employee;
import com.dao.DAO;

public class Service {
DAO dao=new DAO();
	public boolean registerEmployee(Employee e) throws SQLException, ClassNotFoundException {
		System.out.println("Service");
		return dao.registerEmployee(e);
		
	}

}
