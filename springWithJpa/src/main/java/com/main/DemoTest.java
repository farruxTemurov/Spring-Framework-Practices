package com.main;

import javax.enterprise.context.spi.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.service.EmployeeService;

public class DemoTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeService es = (EmployeeService) ac.getBean("employeeService");

		// store Employee
		Employee employee1 = (Employee) ac.getBean("employee");
//		Employee employee1 = Context.getBean(Employee.class);
		employee1.setId(105);
		employee1.setName("Traverse");
		employee1.setSalary(50000);
		String result = es.storeEmployee(employee1);
		System.out.println(result);
	}

}