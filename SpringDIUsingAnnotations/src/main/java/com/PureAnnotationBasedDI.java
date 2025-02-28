package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PureAnnotationBasedDI {

	public static void main(String[] args) {
		// it loads configuration class.
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);

		Address add = (Address) ac.getBean("address");
		System.out.println(add.toString());// default value of city and state
		add.setCity("San Diego");
		add.setState("California");
		System.out.println(add); // by default it calls toString method
		Employee emp = (Employee) ac.getBean("employee");
		System.out.println(emp);
		emp.setId(100);
		emp.setName("Steven");
		emp.setSalary(45000);
		emp.setAdd(add);
		System.out.println(emp);
	}

}