package com;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DemoTest {

	public static void main(String[] args) {
		// load the xml file
		Resource res = new ClassPathResource("beans.xml");
		// BeanFactory object created
		BeanFactory factory = new XmlBeanFactory(res);

		Employee employee1 = (Employee) factory.getBean("emp1");
		employee1.displayEmployee();

		Employee employee2 = (Employee) factory.getBean("emp1");
		employee2.displayEmployee();

	}

}
