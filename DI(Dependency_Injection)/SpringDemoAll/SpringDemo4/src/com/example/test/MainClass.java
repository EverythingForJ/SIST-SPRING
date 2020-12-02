package com.example.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Student;
import com.example.StudentInfo;
import com.example.config.ApplicationConfig1;
import com.example.config.ApplicationConfig2;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig1.class, ApplicationConfig2.class);
		Student jimin = ctx.getBean("student1", Student.class);
		StudentInfo info = ctx.getBean("studentInfo1", StudentInfo.class);
		System.out.println(jimin == info.getStudent());
		
	}
}
