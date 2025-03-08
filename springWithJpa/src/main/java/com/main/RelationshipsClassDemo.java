package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RelationshipsClassDemo {

	public static void main(String[] args) {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		TrainerService ts = (TrainerService) ac.getBean("trainerService");
		StudentService ss = (StudentService) ac.getBean("studentService");

		// store trainer details

		// Trainer t1 = (Trainer)ac.getBean("trainer");
		// t1.setTid(3);
		// t1.setTname("Lex");
		// t1.setTech("AI");
		// String result = ts.storeTrainer(t1);
		// System.out.println(result);

	}

}
