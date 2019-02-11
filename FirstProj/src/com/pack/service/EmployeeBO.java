package com.pack.service;

import java.util.List;

import com.pack.DAO.EmployeeDAO;
import com.pack.model.Employee;

public class EmployeeBO {

	public static int insertEmployee(Employee e) throws Exception{
		int i=EmployeeDAO.insertEmployee(e);
		return i;
		
	}
	public static int updateEmployee(Employee e) throws Exception{
		int i=EmployeeDAO.updateEmployee(e);
		return i;
		
	}
	public static int deleteEmployee(int e) throws Exception{
		int i=EmployeeDAO.deleteEmployee(e);
		return i;
		
	}
	public static List<Employee> viewEmployee() throws Exception{
		List<Employee> i=EmployeeDAO.viewEmployee();
		return i;
		
	}
}
