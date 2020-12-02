package com.example.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class JUnitTest {
	private ApplicationContext ctx;
	
	@BeforeEach
	public void init() {
		this.ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
	}
	
	@Test
	public void test() {
		assertNotNull(this.ctx);
	}
	
}
