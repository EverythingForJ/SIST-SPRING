package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Calculator;
import com.example.StudentVO;


@Configuration
public class AppConfig {
	@Bean
	public StudentVO chulsu() {
		StudentVO student = new StudentVO("2020-01","한지민",89,100,77);
		return student;
	}
	@Bean
	public StudentVO younghee() {
		StudentVO student = new StudentVO("2020-02","박지민",100,99,83);
		return student;
	}
	@Bean
	public Calculator myCalculator() {
		Calculator cal = new Calculator(this.younghee());
		return cal;
	}
}
