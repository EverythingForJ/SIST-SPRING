package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.AdminConnection;

public class AdminConnectionJUnitTest {
	
	private static GenericXmlApplicationContext ctx;
	
	@BeforeClass
	public static void init() {
		ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:beans.xml");
		ctx.refresh();
	}

	@Test
	public void test() {
		assertNotNull(ctx);
	}
	
	@Test
	public void test1() {
		AdminConnection adminConnection = ctx.getBean("adminConnection", AdminConnection.class); 
		assertEquals("javaexpert", adminConnection.getAdminId());
	}
	
	@AfterClass
	public static void after() {
		ctx.close();
	}
}
