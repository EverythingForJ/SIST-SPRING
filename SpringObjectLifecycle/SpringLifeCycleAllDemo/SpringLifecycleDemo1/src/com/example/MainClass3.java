package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass3 {
	public static void main(String[] args) {
		// 1. Container 생성 및 설정
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig3.class);
		
		// 2. Spring Container가 관리하는 Bean 생성
		Product notebook = ctx.getBean("product", Product.class);
		System.out.println(notebook);
		
		// 3. Container 소멸
		ctx.close();
	}
}
