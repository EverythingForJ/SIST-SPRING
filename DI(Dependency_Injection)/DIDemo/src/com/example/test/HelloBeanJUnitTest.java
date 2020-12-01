package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.Hello;
import com.example.Printer;

public class HelloBeanJUnitTest {
	private ApplicationContext ctx;

	@Before
	public void init() {
		// 항상 먼저 ApplicationContext를 생성해야 하기 때문에
		// 1. IoC Container 생성
		String path = "classpath:beans.xml";
		this.ctx = new GenericXmlApplicationContext(path);
	}

	@Ignore @Test
	public void test1() {
		// 2. Hello Beans 가져오기
		Hello hello = (Hello) ctx.getBean("hello");
		assertEquals("Hello 김지민", hello.sayHello());
	}

	@Ignore @Test
	public void test2() {
		// 3. SpringPrinter 가져오기
		Hello hello = (Hello) ctx.getBean("hello");
		hello.print();
		Printer sprinter = (Printer) ctx.getBean("sPrinter");
		assertEquals("Hello 김지민", sprinter.toString());
	}
	
	@Test
	public void test3() {
		Hello hello = (Hello)this.ctx.getBean("hello");
		Hello hello1 = this.ctx.getBean("hello", Hello.class);
		assertSame(hello, hello1);
	}
}
