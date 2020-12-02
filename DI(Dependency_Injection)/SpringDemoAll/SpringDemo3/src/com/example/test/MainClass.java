package com.example.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.Product;
import com.example.Student;
import com.example.StudentInfo;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:applicationContext.xml";
		String path2 = "classpath:applicationContext2.xml";
		ApplicationContext ctx = new GenericXmlApplicationContext(path, path2);
		Student jimin = ctx.getBean("student1", Student.class);
		StudentInfo info = ctx.getBean("studentInfo1", StudentInfo.class);
		if(jimin == info.getStudent()) System.out.println("같은 학생이다.");
		else System.out.println("다른 학생이다.");
		
		Product p = ctx.getBean("product", Product.class);
		System.out.println(p);
	}
}
