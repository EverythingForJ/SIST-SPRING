package com.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Calculator;
import com.example.StudentVO;
import com.example.config.AppConfig;

public class SungjukMgmtTest {
	private ApplicationContext ctx;
	private Calculator myCalculater;
	
	@Before
	public void init() {
		this.ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		myCalculater = this.ctx.getBean("myCalculator", Calculator.class);
		myCalculater.calcTot();
		myCalculater.calcAvg();
		myCalculater.calcGrade();
	}
	
	@Test
	public void test() {
		StudentVO younghee = this.ctx.getBean("younghee", StudentVO.class);
		assertEquals("박지민", younghee.getName());
	}

	@Test
	public void test1() {
		StudentVO younghee = (StudentVO)this.ctx.getBean("younghee");
		assertEquals(100+99+83, younghee.getTot());
	}

}
