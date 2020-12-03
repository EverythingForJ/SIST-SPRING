package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass2 {
	public static void main(String[] args) {
		// 1. Container 생성 및 설정
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		// 2. String Container가 관리하는 bean 생성
		Student chulsu = (Student)ctx.getBean("student3");
		System.out.println(chulsu);
		
		// 3. Container 소멸
		ctx.close();
		
		// 1. Container 생성 및 설정
		ctx = new AnnotationConfigApplicationContext(ApplicationConfig2.class);
		
		// 2. String Container가 관리하는 bean 생성
		Student jimin = ctx.getBean("student4", Student.class);
		System.out.println(jimin);
		
		// 3. Container 소멸
		ctx.close();
	}
}
