package com.main;

import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bean.Employee;
import com.service.EmployeeService;
import com.dao.EmployeeDao; // Importing DAO for find, update, delete methods

public class DemoTest {

	public static void main(String[] args) {
		// Load the Spring configuration file
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		// Get service and DAO beans
		EmployeeService es = (EmployeeService) ac.getBean("employeeService");
		EmployeeDao ed = (EmployeeDao) ac.getBean("employeeDao");

		Scanner sc = new Scanner(System.in);
		int choice;

		// Menu inside do-while loop
		do {
			System.out.println("\n===== Employee Management System =====");
			System.out.println("1. Add Employee");
			System.out.println("2. Delete Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. View All Employees");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1: // Insert Employee
				Employee employee1 = (Employee) ac.getBean("employee"); // Create new Employee object
				System.out.print("Enter ID: ");
				employee1.setId(sc.nextInt());
				System.out.print("Enter Name: ");
				employee1.setName(sc.next());
				System.out.print("Enter Salary: ");
				employee1.setSalary(sc.nextFloat());

				String result = es.storeEmployee(employee1);
				System.out.println(result);
				break;

			case 2: // Delete Employee
				System.out.print("Enter Employee ID to delete: ");
				int delId = sc.nextInt();
				String delMessage = es.deleteEmployee(delId); // Call service method
				System.out.println(delMessage);
				break;

			case 3: // Update Employee
				Employee employee2 = (Employee) ac.getBean("employee");

				System.out.print("Enter Employee ID to update: ");
				employee2.setId(sc.nextInt());

				System.out.print("Enter New Name: ");
				employee2.setName(sc.next());

				System.out.print("Enter New Salary: ");
				employee2.setSalary(sc.nextFloat());

				String updateMessage = es.updateEmployee(employee2); // Call service method
				System.out.println(updateMessage);
				break;

//			case 4: // View All Employees
//				List<Employee> employees = es.viewAllEmployees(); // Call service method
//				if (employees.isEmpty()) {
//					System.out.println("No employees found.");
//				} else {
//					System.out.println("=== Employee List ===");
//					for (Employee emp : employees) {
//						System.out.println(
//								"ID: " + emp.getId() + ", Name: " + emp.getName() + ", Salary: " + emp.getSalary());
//					}
//				}
//				break;

			case 5: // Exit
				System.out.println("Exiting program...");
				break;

			default:
				System.out.println("Invalid choice. Please try again.");
			}

		} while (choice != 5); // Keep running until the user chooses to exit

		sc.close(); // Close the scanner
	}
}
