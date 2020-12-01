package com.example.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.Hello;
import com.example.Printer;

public class HelloBeanTest {
	public static void main(String[] args) {
		
		// 1. IoC Container 생성
		String path = "classpath:beans.xml";		
		AbstractApplicationContext context = new GenericXmlApplicationContext(path);
		
		// 2. Hello Beans 가져오기
		Hello hello = (Hello) context.getBean("hello");
		// System.out.println(hello.sayHello());
		hello.print(); // Hello 한지민을 StringBuffer에 담는다.
		
		// 3. SpringPrinter 가져오기
		Printer printer = (Printer) context.getBean("sPrinter");
		System.out.println(printer.toString());

		
		Hello hello2 = context.getBean("hello", Hello.class);
		if(hello2 == hello) System.out.println("같은 객체다.");
		else System.out.println("다른 객체다.");
		
		context.close();
	}
}
