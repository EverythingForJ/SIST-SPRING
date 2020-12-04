package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.AdminConnection;
import com.example.ApplicationConfig;

public class AdminConnectionJUnitTest {
	private AnnotationConfigApplicationContext ctx;
	
	@BeforeEach
	public void init() {
		this.ctx = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);		
	}
	
	@Test
	public void test() {
		assertNotNull(this.ctx);
	}
	
	@Test
	public void test1() {
		AdminConnection adminConnection = this.ctx.getBean("adminConnection", AdminConnection.class);
		assertEquals("javasoft", adminConnection.getSubAdminId());
	}
}
