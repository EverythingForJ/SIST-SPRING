package com.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.Calculator;
import com.example.StudentVO;

public class SungjukMgmtTest {
	private ApplicationContext ctx;
	private Calculator myCalculater;
	@Before
	public void init() {
		String path = "classpath:beans.xml";
		this.ctx = new GenericXmlApplicationContext(path);
		myCalculater = this.ctx.getBean("myCalculator", Calculator.class);
		myCalculater.calcTot();
		myCalculater.calcAvg();
		myCalculater.calcGrade();
	}
	
	@Test
	public void test() {
		StudentVO chulsu = this.ctx.getBean("chulsu", StudentVO.class);
		assertEquals("한지민", chulsu.getName());
	}

	@Test
	public void test1() {
		StudentVO chulsu = (StudentVO)this.ctx.getBean("chulsu");
		assertEquals(89+100+77, chulsu.getTot());
	}

}
