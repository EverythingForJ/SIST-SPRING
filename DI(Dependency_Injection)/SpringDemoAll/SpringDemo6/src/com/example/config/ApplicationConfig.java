package com.example.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.example.Student;

@Configuration
@ImportResource("classpath:ApplicationContext.xml")
public class ApplicationConfig {
	@Bean
	public Student student1() {
		List<String> list = Arrays.asList("독서", "영화감상", "요리");
		Student student1 = new Student("한지민", 25, list);
		student1.setHeight(165);
		student1.setWeight(45);
		return student1;
	}
}
