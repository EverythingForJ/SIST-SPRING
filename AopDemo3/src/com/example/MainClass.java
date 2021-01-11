package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext ctx = new
				GenericXmlApplicationContext("classpath:beans.xml");
		
		Student student = ctx.getBean("student", Student.class);
		student.getStudentInfo();
		Worker worker = ctx.getBean("worker", Worker.class);
		worker.getWorkerInfo();
	}
}
