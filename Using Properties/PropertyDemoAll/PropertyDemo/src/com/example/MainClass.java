package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:beans.xml");
		Hello1 hello1 = (Hello1) ctx.getBean("hello1");
		System.out.println(hello1.sayHello());
		hello1.print();
		Printer printer = ctx.getBean("stringPrinter", StringPrinter.class);
		System.out.println(printer.toString());
		hello1.getHobbies().forEach(value -> System.out.println(value));
		System.out.println("취미갯수 : "+hello1.getHobbies().size());
	}
}
