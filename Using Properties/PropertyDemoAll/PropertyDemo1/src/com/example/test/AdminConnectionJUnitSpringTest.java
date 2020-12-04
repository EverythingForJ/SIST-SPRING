package com.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.AdminConnection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:beans.xml"})
public class AdminConnectionJUnitSpringTest {
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void test() {
		AdminConnection adminConnection = this.ctx.getBean("adminConnection", AdminConnection.class);
		assertEquals("987654321", adminConnection.getSubAdminPwd());
	}
	
}
