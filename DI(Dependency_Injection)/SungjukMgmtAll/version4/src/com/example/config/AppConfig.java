package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Calculator;
import com.example.StudentVO;


@Configuration
public class AppConfig {
	@Bean
	public StudentVO chulsu() {
		StudentVO student = new StudentVO();
		student.setHakbun("2020-01");
		student.setName("한지민");
		student.setKor(89);
		student.setEng(100);
		student.setMat(77);
		return student;
	}
	@Bean
	public StudentVO younghee() {
		StudentVO student = new StudentVO();
		student.setHakbun("2020-02");
		student.setName("박지민");
		student.setKor(100);
		student.setEng(99);
		student.setMat(83);
		return student;
	}
	@Bean
	public Calculator myCalculator() {
		Calculator cal = new Calculator();
		cal.setStudent(this.younghee());
		return cal;
	}
}
