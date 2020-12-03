package com.example;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	@Bean
	public Student student3() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("낚시");
		list.add("등산");
		list.add("바둑");
		Student student3 = new Student("홍지민", 28, list);
		student3.setHeight(163.8);
		student3.setWeight(56.2);
		return student3;
	}
}
