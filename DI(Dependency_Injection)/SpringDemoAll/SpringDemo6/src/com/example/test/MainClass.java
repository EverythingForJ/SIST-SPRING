package com.example.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Student;
import com.example.config.ApplicationConfig;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Student jimin = ctx.getBean("student1", Student.class);
		Student jimin1 = ctx.getBean("student3", Student.class);
		System.out.println(jimin);
		System.out.println(jimin1);
	}
}
