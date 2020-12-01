package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.Hello;
import com.example.Printer;
import com.example.StringPrinter;
import com.example.config.AppCtx;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppCtx.class})
public class HelloBeanJUnitSpringTest {
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void method1() {
		Hello hello = (Hello)this.ctx.getBean("hello");
		assertEquals("Hello 박지민", hello.sayHello());
	}
	@Test
	public void method2() {
		Hello hello = this.ctx.getBean("hello", Hello.class);
		hello.print();
		Printer printer = this.ctx.getBean("sPrinter", StringPrinter.class);
		assertEquals("Hello 박지민", printer.toString());
	}
	
	@Test
	public void method3() {
		Printer printer = this.ctx.getBean("sPrinter", StringPrinter.class);
		Printer printer1 = (StringPrinter)this.ctx.getBean("sPrinter");
		assertSame(printer, printer1);
	}
}
