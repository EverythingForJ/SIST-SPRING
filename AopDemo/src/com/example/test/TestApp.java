package com.example.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Student;
import com.example.Worker;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
class TestApp {
	@Autowired
	private Student student;
	
	@Autowired
	private Worker worker;
	
	@Test
	public void test() {
//		Student student = this.ctx.getBean("student", Student.class);
		student.getStudentInfo();
//		Worker worker = this.ctx.getBean("worker", Worker.class);
		worker.getWorkerInfo();
	}

}
