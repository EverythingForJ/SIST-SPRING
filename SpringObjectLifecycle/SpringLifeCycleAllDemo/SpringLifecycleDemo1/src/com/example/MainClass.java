package com.example;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		// 1. Container 생성
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		
		// 2. 컨테이너 설정
		context.load("classpath:applicationContext.xml");
		context.refresh(); // 반드시
		
		// 3. String Container가 관리하는 bean 생성
		Student student1 = context.getBean("student1", Student.class);
		System.out.println(student1);
		
		// 4. Container 소멸
		context.close();
		
		
		
		context = new GenericXmlApplicationContext();
		context.load("classpath:applicationContext2.xml");
		context.refresh(); // 반드시
		
		// 3. String Container가 관리하는 bean 생성
		Student jimin = context.getBean("student2", Student.class);
		System.out.println(jimin);
		
		// 4. Container 소멸
		context.close();
	}
}
