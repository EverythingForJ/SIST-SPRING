package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.Hello;
import com.example.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class HelloBeanJunitSpringTest {
	
	@Autowired
	private ApplicationContext ctx;
	
	@Ignore @Test
	public void test1() {
		// 2. Hello Beans 가져오기
		Hello hello = (Hello) ctx.getBean("hello");
		assertEquals("Hello 김지민", hello.sayHello());
	}

	@Test
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
