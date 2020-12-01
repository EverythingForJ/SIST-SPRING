package com.example.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Hello;
import com.example.Printer;
import com.example.config.AppCtx;

public class HelloBeanTest {
	public static void main(String[] args) {
		// 1. IoC Container 생성
		// Hello hello = new Hello();
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

		// 2. Hello Beans 가져오기
		Hello hello = (Hello) ctx.getBean("hello");
		System.out.println(hello.sayHello());
		hello.print();

		// 3. SpringPrinter 가져오기
		Printer sPrinter = ctx.getBean("sPrinter", Printer.class);
		System.out.println(sPrinter.toString());
		
		Hello hello2 = ctx.getBean("hello", Hello.class);
		hello2.print();
		System.out.println(hello == hello2);
	}
}
