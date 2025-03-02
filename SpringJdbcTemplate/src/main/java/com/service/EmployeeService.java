package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;

@Service // service layer annotation which contains business logic
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	public String storeEmployee(Employee employee) {
		if (employee.getSalary() < 10000) {
			return "Salary must be > 10000";
		} else if (employeeDao.storeEmployee(employee) > 0) {
			return "Employee record stored successfully";
		} else {
			return "Employee record wasn't stored";
		}
	}

	public String deleteEmployee(int id) {
		int result = employeeDao.deleteEmployee(id); // Call DAO method
		if (result > 0) {
			return "Employee deleted successfully.";
		} else {
			return "Employee not found.";
		}
	}

	public String updateEmployee(Employee employee) {
		int result = employeeDao.updateEmployee(employee); // Call DAO method
		if (result > 0) {
			return "Employee updated successfully.";
		} else {
			return "Employee not found.";
		}
	}

//	public List<Employee> viewAllEmployees() {
//		return employeeDao.findAllEmployees(); // Fetch all employees from DAO
//	}

}