package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bean.Employee;

@Repository // DAO layer annotation
public class EmployeeDao {

	@Autowired
	DataSource ds; // it searches the database connection in beans.xml file
	// if present, it does DI for that data source. By default, it is considered as byType.

	public int storeEmployee(Employee employee) {
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into employees values(?,?,?)");
			pstmt.setInt(1, employee.getId());
			pstmt.setString(2, employee.getName());
			pstmt.setFloat(3, employee.getSalary());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.toString());
			return 0;
		}
	}

	public int deleteEmployee(int id) {
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from employees where id=?");
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.toString());
			return 0;
		}
	}

	public int updateEmployee(Employee employee) {
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update employees set salary=?,name=? where id=?");
			pstmt.setFloat(1, employee.getSalary());
			pstmt.setString(2, employee.getName());
			pstmt.setInt(3, employee.getId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.toString());
			return 0;
		}
	}

	public List<Employee> findAllEmployees() {
		List<Employee> listofEmp = new ArrayList<Employee>();
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from employees");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getFloat(3));
				listofEmp.add(emp);
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return listofEmp;
	}
}
