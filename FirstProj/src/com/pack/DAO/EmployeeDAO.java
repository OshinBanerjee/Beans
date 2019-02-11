package com.pack.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pack.JDBCConnection;
import com.pack.model.Employee;

public class EmployeeDAO {
 public static int insertEmployee(Employee e) throws Exception{
	 Connection con=JDBCConnection.getConnection();
	 PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?)");
	 ps.setInt(1,e.getId());
	 ps.setString(2,e.getName());
	 ps.setFloat(3,e.getSalary());
	 java.sql.Date d1=new java.sql.Date(e.getDob().getTime());//convert util date to sql date
	 ps.setDate(4,d1);
	 ps.setString(5,e.getDesignation());
	 int i=ps.executeUpdate();
	 con.close();
	 return i;
 }
 public static int updateEmployee(Employee e) throws Exception{ 
	 Connection con=JDBCConnection.getConnection();
	 PreparedStatement ps=con.prepareStatement("update employee set salary=?,designation=? where id=?");
	 ps.setFloat(1,e.getSalary());
	 ps.setString(2,e.getDesignation());
	 ps.setInt(3,e.getId());
	 int i=ps.executeUpdate();
	 con.close();
	 return i;
 }
 public static int deleteEmployee(int e) throws Exception{
	 Connection con=JDBCConnection.getConnection();
	 PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
	 ps.setInt(1,e);
	 int i=ps.executeUpdate();
	 con.close();
	 return i;
 } 
 public static List<Employee> viewEmployee() throws Exception{
	 Connection con=JDBCConnection.getConnection();
	 Statement st=con.createStatement();
	 ResultSet rst=st.executeQuery("select * from employee");
	 //ResultSet rst=st.executeQuery("select name,salary from employee");
	 List<Employee> l=new ArrayList<>();
	  while(rst.next()){
		Employee e=new Employee();
		e.setId(rst.getInt(1));
		e.setName(rst.getString(2));//String s=rst.getString(1);
		e.setSalary(rst.getFloat(3));//int sa=rst.getInt(2);
		java.util.Date d=new java.util.Date(rst.getDate(4).getTime());
		e.setDob(d);
		e.setDesignation(rst.getString(5));
	    l.add(e);
	  }
	  con.close();
	return l;
 }
}
