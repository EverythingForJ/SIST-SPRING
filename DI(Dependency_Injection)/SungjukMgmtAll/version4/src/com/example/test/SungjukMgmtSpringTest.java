package com.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.Calculator;
import com.example.StudentVO;
import com.example.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class SungjukMgmtSpringTest {
	@Autowired
	private ApplicationContext context;
	
	@Test
	public void method() {
		Calculator myCalculator = this.context.getBean("myCalculator", Calculator.class);
		myCalculator.calcTot();
		myCalculator.calcAvg();
		myCalculator.calcGrade();
		
		StudentVO younghee = this.context.getBean("younghee", StudentVO.class);
		// assertNotNull(younghee);
		// assertEquals("A", ""+younghee.getGrade());
		assertEquals("A", String.valueOf(younghee.getGrade()));
	}
	
}
