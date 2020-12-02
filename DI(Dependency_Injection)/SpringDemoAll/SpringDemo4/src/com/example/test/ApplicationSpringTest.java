package com.example.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.config.ApplicationConfig1;
import com.example.config.ApplicationConfig2;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:applicationContext2.xml"})
@ContextConfiguration(classes = {ApplicationConfig1.class, ApplicationConfig2.class})
public class ApplicationSpringTest {
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void test() {
		assertNotNull(this.ctx);
	}
}
