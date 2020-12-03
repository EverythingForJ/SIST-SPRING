package com.example;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		// 1. Container 생성
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		
		// 2. Container 설정
		context.load("classpath:applicationContext.xml");
		context.refresh();
		
		Student student = context.getBean("student", Student.class);
		System.out.println(student);
		
		// 3. Container 소멸 및 bean 소멸
		context.close();
	}
}
