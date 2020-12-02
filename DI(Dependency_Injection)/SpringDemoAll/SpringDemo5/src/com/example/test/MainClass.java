package com.example.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.Student;

public class MainClass {
	public static void main(String[] args) {
		String configFile = "classpath:applicationContext.xml";
		AbstractApplicationContext context = new GenericXmlApplicationContext(configFile);
		Student student1 = context.getBean("student1", Student.class);
		System.out.println(student1);
		Student student3 = context.getBean("student3", Student.class);
		System.out.println(student3);
		context.close();
	}
}
