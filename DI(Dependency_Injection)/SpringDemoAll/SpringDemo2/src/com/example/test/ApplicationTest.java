package com.example.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.StudentInfo;
import com.example.config.ApplicationConfig;

public class ApplicationTest {
	
	private ApplicationContext ctx;
	
	@Before
	public void init() {
		this.ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	}
	
	@Ignore @Test
	public void test() {
		assertNotNull(this.ctx);
	}

	@Test
	public void test1() {
//		Student jimin = this.ctx.getBean("student1", Student.class);
//		System.out.println(jimin);
//		Student jimin1 = (Student)this.ctx.getBean("student2");
//		System.out.println(jimin1);
		StudentInfo info = this.ctx.getBean("studentInfo", StudentInfo.class);
		info.printInfo();
	}
}
