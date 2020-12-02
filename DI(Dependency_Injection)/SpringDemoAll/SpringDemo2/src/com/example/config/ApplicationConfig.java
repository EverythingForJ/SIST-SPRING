package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Student;
import com.example.StudentInfo;

@Configuration
public class ApplicationConfig {
	@Bean
	public Student student1() {
		return new Student("한지민", 15, 2, 5);
	}

	@Bean
	public Student student2() {
		return new Student("김지민", 16, 3, 7);
	}

	@Bean
	public StudentInfo studentInfo() {
		return new StudentInfo(this.student1());
	}
}
