package com.example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Student student = context.getBean("student", Student.class);
		System.out.println(student);
		System.out.println("----------------------------------");
		Student student1 = context.getBean("student", Student.class);
		student1.setName("설운도");
		student1.setAge(55);
		student1.setGender("male");
		student1.setCity("대구");
		System.out.println(student1);
		
		System.out.println("----------------------------------");
		// if (student.equals(student1))
		if (student == student1)
			System.out.println("Equals"); // Print Equals
		else
			System.out.println("Different");
		context.close();
	}
}
